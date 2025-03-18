package com.example.vigiform.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DrawerItems(
    label: String,
    selected: Boolean,
    icon: ImageVector,
    contentDescription: String,
    route: String,
    navigationController: NavController,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState
) {
    NavigationDrawerItem(
        label = {
            Text(text = label)
        },
        selected = selected,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
        },
        onClick = {
            coroutineScope.launch {
                drawerState.close()
            }

            navigationController.navigate(route) {
                popUpTo(0)
            }
        }
    )
}