package com.sats.spikes.navigation.core.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
  val destination: String
  val arguments: List<NamedNavArgument>
}
