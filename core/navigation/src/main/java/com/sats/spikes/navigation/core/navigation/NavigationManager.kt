package com.sats.spikes.navigation.core.navigation

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

@Singleton
class NavigationManager @Inject constructor() {
  private val _commands = MutableSharedFlow<NavigationCommand>(replay = 1)
  val commands: SharedFlow<NavigationCommand> = _commands.asSharedFlow()

  suspend fun navigate(directions: NavigationCommand) {
    _commands.emit(directions)
  }
}
