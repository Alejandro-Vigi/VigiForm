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

/**
 * ES: DrawerItems es una función composable que representa un ítem dentro del menú lateral (Drawer)
 * de una aplicación en Jetpack Compose. Nos permite mostrar un texto, un ícono y manejar la navegación
 * hacia una ruta específica cuando el usuario lo selecciona. Además, se encarga de cerrar el Drawer
 * automáticamente usando corrutinas. También indica visualmente si el ítem está seleccionado.
 *
 * EN: DrawerItems is a composable function that represents an item inside the side navigation menu (Drawer)
 * in a Jetpack Compose app. It displays a label, an icon, and handles navigation to a specific route
 * when clicked. It also automatically closes the Drawer using coroutines, and visually indicates
 * whether the item is currently selected.
 */

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