package com.example.vigiform

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.vigiform.navigation.DrawerItems
import com.example.vigiform.navigation.Items
import com.example.vigiform.navigation.NavigationHost
import com.example.vigiform.ui.theme.VigiFormTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VigiFormTheme {
                NavDrawer()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer() {
    val context = LocalContext.current
    val items = Items.getItems(context)
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp * 0.6f)
                    .statusBarsPadding() // Asegura que el drawer se extienda debajo de la barra de estado
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .background(Color(122, 98, 156))
                ) {
                    Text(text = "")
                }

                Spacer(modifier = Modifier.height(20.dp))

                for (item in items) {
                    DrawerItems(
                        label = item.label,
                        selected = item.selected,
                        icon = item.icon,
                        contentDescription = item.contentDescription,
                        route = item.route,
                        coroutineScope = coroutineScope,
                        drawerState = drawerState,
                        navigationController = navigationController
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = {
                        Text(text = "VigiForm - Calculadora")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menú"
                            )
                        }
                    },
                    actions = {
                        val context = LocalContext.current
                        IconButton(onClick = {
                            val githubLink = "https://github.com/Alejandro-Vigi/VigiForm"
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, githubLink)
                            }
                            context.startActivity(Intent.createChooser(intent, "Compartir enlace"))
                        }) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Compartir"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(122, 98, 156), // Color de fondo de la TopAppBar
                        titleContentColor = Color.White, // Color del título
                        navigationIconContentColor = Color.White, // Color del ícono de navegación
                        actionIconContentColor = Color.White // Color de los íconos de acciones
                    )
                )
            }
        ) {
            NavigationHost(
                navController = navigationController,
            )
        }
    }
}