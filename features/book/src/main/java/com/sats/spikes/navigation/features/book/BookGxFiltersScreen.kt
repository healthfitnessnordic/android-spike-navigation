package com.sats.spikes.navigation.features.book

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.TopAppBar

@Composable
fun BookGxFiltersScreen() {
  Scaffold(
    topBar = {
      TopAppBar(title = { Text("Book GX Filters") })
    },
  ) { contentPadding ->
    Box(Modifier.padding(contentPadding))
  }
}
