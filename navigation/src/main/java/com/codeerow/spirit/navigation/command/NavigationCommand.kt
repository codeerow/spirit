package com.codeerow.spirit.navigation.command

import com.codeerow.spirit.core.command.ViewCommand


abstract class NavigationCommand : ViewCommand() {

    var handled = false
}