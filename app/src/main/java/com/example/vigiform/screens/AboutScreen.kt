package com.example.vigiform.screens

import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vigiform.navigation.getInstagram
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.res.painterResource
import androidx.core.net.toUri
import com.example.vigiform.navigation.getLinkedinLogo
import com.example.vigiform.R
import com.example.vigiform.navigation.getGithub

/**
 * ES: AboutScreen es una función composable que representa una pantalla de información dentro de la
 * aplicación. Muestra detalles sobre el creador de la app (Marco Alejandro Vigi Garduño), incluyendo nombre, la facultad y la versión
 * de la aplicación. También muestra los íconos de las redes sociales como Instagram, LinkedIn y GitHub,
 * que al hacer clic redirigen al usuario a los perfiles correspondientes. Utiliza un diseño de Columnas
 * y Filas, con imágenes y textos alineados adecuadamente en la pantalla.
 *
 * EN: AboutScreen is a composable function that represents an information screen within the app. It displays
 * details about the app creator, including their name (Marco Alejandro Vigi Garduño), the faculty, and the app version. It also shows social media
 * icons for Instagram, LinkedIn, and GitHub, which, when clicked, redirect the user to the corresponding profiles.
 * The layout uses Columns and Rows, with images and text properly aligned on the screen.
 */

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(130.dp))
            Text(
                text = "VigiForm",
                fontSize = 25.sp
            )

            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Icono de fórmula",
                modifier = Modifier
                    .size(130.dp) // puedes ajustar el tamaño
                    .padding(16.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "Creado por: Vigi Garduño Marco Alejandro",
                fontSize = 16.sp
            )

            Text(
                text = "Facultad de Ingeniería - 2025 ©",
                fontSize = 15.sp
            )

            Text(
                text = "Version: 1.0",
                fontSize = 15.sp
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(0.8f),
                thickness = 1.dp,
                color = Color.Black
            )

            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Icon(
                    imageVector = getInstagram(context),
                    contentDescription = "Instagram Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW,
                                "https://www.instagram.com/alejandro_vigi".toUri())
                            context.startActivity(intent)
                        },
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                Icon(
                    imageVector = getLinkedinLogo(context),
                    contentDescription = "LinkedIn Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW,
                                "https://www.linkedin.com/in/alejandro-vigi/".toUri())
                            context.startActivity(intent)
                        },
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                Icon(
                    imageVector = getGithub(context),
                    contentDescription = "Github Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW,
                                "https://github.com/Alejandro-Vigi".toUri())
                            context.startActivity(intent)
                        },
                    tint = Color.Black
                )
            }

        }
    }
}