package com.sats.spikes.navigation.app

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.google.accompanist.insets.ui.BottomNavigation
import com.sats.spikes.navigation.core.navigation.NavigationCommand
import com.sats.spikes.navigation.core.navigation.NavigationDirections

@Composable
internal fun BottomNavBar(onItemClicked: (NavigationCommand) -> Unit) {
  BottomNavigation(
    contentPadding = WindowInsets.navigationBars.asPaddingValues(),
    backgroundColor = MaterialTheme.colors.surface,
  ) {
    BottomNavigationItem(
      selected = false,
      icon = { Icon(Icons.Default.Home, contentDescription = null) },
      label = { Text("Home") },
      onClick = { onItemClicked(NavigationDirections.Home) },
    )
    BottomNavigationItem(
      selected = false,
      icon = { Icon(Icons.Default.AddCircle, contentDescription = null) },
      label = { Text("Book") },
      onClick = { onItemClicked(NavigationDirections.Book.Landing) },
    )
    BottomNavigationItem(
      selected = false,
      icon = { Icon(Icons.Default.QrCode2, contentDescription = null) },
      label = { Text("CheckIn") },
      onClick = { onItemClicked(NavigationDirections.CheckIn) },
    )
    BottomNavigationItem(
      selected = false,
      icon = { Icon(Icons.Default.Search, contentDescription = null) },
      label = { Text("Clubs") },
      onClick = { onItemClicked(NavigationDirections.Clubs) },
    )
    BottomNavigationItem(
      selected = false,
      icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
      label = { Text("Profile") },
      onClick = { onItemClicked(NavigationDirections.Profile) },
    )
  }
}
