package com.sats.spikes.navigation.features.book

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.accompanist.insets.ui.TopAppBar
import com.sats.spikes.navigation.core.navigation.NavigationDirections
import com.sats.spikes.navigation.core.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@Composable
fun BookGxScreen(viewModel: BookGxScreenViewModel = hiltViewModel()) {
  Scaffold(
    topBar = {
      TopAppBar(
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
        title = { Text("Book GX") },
      )
    },
    floatingActionButton = {
      ExtendedFloatingActionButton(
        text = { Text("Filters") },
        icon = { Icon(Icons.Default.FilterList, contentDescription = null) },
        onClick = viewModel::onFiltersButtonClicked,
      )
    },
  ) { contentPadding ->
    Box(Modifier.padding(contentPadding))
  }
}

@HiltViewModel
class BookGxScreenViewModel @Inject constructor(
  private val navigationManager: NavigationManager,
) : ViewModel() {
  fun onFiltersButtonClicked() {
    viewModelScope.launch {
      navigationManager.navigate(NavigationDirections.Book.Gx.Filters)
    }
  }
}
