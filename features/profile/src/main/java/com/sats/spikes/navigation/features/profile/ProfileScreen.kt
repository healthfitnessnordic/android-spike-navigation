package com.sats.spikes.navigation.features.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.TopAppBar

@Composable
fun ProfileScreen() {
  Scaffold(
    topBar = {
      TopAppBar(
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
        title = { Text("Profile") },
      )
    },
  ) { contentPadding ->
    Box(Modifier.padding(contentPadding))
  }
}
