package com.sats.spikes.navigation.core.navigation

import androidx.navigation.NamedNavArgument

object NavigationDirections {
  val Empty = object : NavigationCommand {
    override val destination = ""
    override val arguments = listOf<NamedNavArgument>()
  }

  object Book {
    const val root = "book"

    val Landing = object : NavigationCommand {
      override val destination: String = "$root/landing"
      override val arguments = listOf<NamedNavArgument>()
    }

    object Gx {
      const val root = "${Book.root}/gx"

      val Landing = object : NavigationCommand {
        override val destination: String = "$root/landing"
        override val arguments = listOf<NamedNavArgument>()
      }

      val Filters = object : NavigationCommand {
        override val destination: String = "$root/filters"
        override val arguments = listOf<NamedNavArgument>()
      }
    }
  }

  val CheckIn = object : NavigationCommand {
    override val destination: String = "checkIn"
    override val arguments = listOf<NamedNavArgument>()
  }

  val Clubs = object : NavigationCommand {
    override val destination: String = "clubs"
    override val arguments = listOf<NamedNavArgument>()
  }

  val Home = object : NavigationCommand {
    override val destination: String = "home"
    override val arguments = listOf<NamedNavArgument>()
  }

  val Profile = object : NavigationCommand {
    override val destination: String = "profile"
    override val arguments = listOf<NamedNavArgument>()
  }
}
