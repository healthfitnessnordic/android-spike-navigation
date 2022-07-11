package com.sats.spikes.navigation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.sats.spikes.navigation.core.navigation.NavigationCommand
import com.sats.spikes.navigation.core.navigation.NavigationDirections
import com.sats.spikes.navigation.core.navigation.NavigationManager
import com.sats.spikes.navigation.features.book.BookGxFiltersScreen
import com.sats.spikes.navigation.features.book.BookGxScreen
import com.sats.spikes.navigation.features.book.BookScreen
import com.sats.spikes.navigation.features.checkin.CheckInScreen
import com.sats.spikes.navigation.features.clubs.ClubsScreen
import com.sats.spikes.navigation.features.home.HomeScreen
import com.sats.spikes.navigation.features.profile.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AppViewModel @Inject constructor(
  private val navigationManager: NavigationManager,
) : ViewModel() {
  fun onBottomBarItemClicked(command: NavigationCommand) {
    viewModelScope.launch {
      navigationManager.navigate(command)
    }
  }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject
  lateinit var navigationManager: NavigationManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      App(navigationManager = navigationManager)
    }
  }
}

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
private fun App(viewModel: AppViewModel = hiltViewModel(), navigationManager: NavigationManager) {
  val bottomSheetNavigator = rememberBottomSheetNavigator()
  val navController = rememberNavController(bottomSheetNavigator)

  LaunchedEffect(Unit) {
    navigationManager.commands.collect { command ->
      if (command.destination.isNotEmpty()) {
        navController.navigate(command.destination)
      }
    }
  }

  MaterialTheme {
    ModalBottomSheetLayout(bottomSheetNavigator) {
      Scaffold(
        bottomBar = {
          BottomNavBar(onItemClicked = viewModel::onBottomBarItemClicked)
        },
      ) { contentPadding ->
        NavHost(
          modifier = Modifier.padding(contentPadding),
          navController = navController,
          startDestination = NavigationDirections.Home.destination,
        ) {
          composable(NavigationDirections.Home.destination) {
            HomeScreen()
          }

          navigation(
            route = NavigationDirections.Book.root,
            startDestination = NavigationDirections.Book.Landing.destination,
          ) {
            composable(NavigationDirections.Book.Landing.destination) {
              BookScreen()
            }

            navigation(
              route = NavigationDirections.Book.Gx.root,
              startDestination = NavigationDirections.Book.Gx.Landing.destination,
            ) {
              composable(NavigationDirections.Book.Gx.Landing.destination) {
                BookGxScreen()
              }

              bottomSheet(NavigationDirections.Book.Gx.Filters.destination) {
                BookGxFiltersScreen()
              }
            }
          }

          composable(NavigationDirections.CheckIn.destination) {
            CheckInScreen()
          }

          composable(NavigationDirections.Clubs.destination) {
            ClubsScreen()
          }

          composable(NavigationDirections.Profile.destination) {
            ProfileScreen()
          }
        }
      }
    }
  }
}
