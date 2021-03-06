package com.sats.spikes.navigation.features.book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
fun BookScreen(viewModel: BookScreenViewModel = hiltViewModel()) {
  Scaffold(
    topBar = {
      TopAppBar(
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
        title = { Text("Book") },
      )
    },
  ) { contentPadding ->
    Column(
      Modifier
        .padding(contentPadding)
        .fillMaxSize()
        .wrapContentSize(),
    ) {
      OutlinedButton(onClick = viewModel::onGxButtonClicked) {
        Text("GX Booking")
      }

      OutlinedButton(onClick = viewModel::onPtButtonClicked, enabled = false) {
        Text("PT Booking")
      }

      OutlinedButton(onClick = viewModel::onTreatmentsButtonClicked, enabled = false) {
        Text("Treatments")
      }
    }
  }
}

@HiltViewModel
class BookScreenViewModel @Inject constructor(
  private val navigationManager: NavigationManager,
) : ViewModel() {
  fun onGxButtonClicked() {
    viewModelScope.launch {
      navigationManager.navigate(NavigationDirections.Book.Gx.Landing)
    }
  }

  fun onPtButtonClicked() {
  }

  fun onTreatmentsButtonClicked() {
  }
}
