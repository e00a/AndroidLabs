package com.mdk0103.labwork28

sealed class Screens(val route: String) {
    object Read: Screens("read")
    object Add: Screens("add")
    object Edit: Screens("edit")
    object Delete: Screens("delete")
}