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
import com.example.vigiform.navigation.Instagram
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.ui.res.painterResource
import com.example.vigiform.navigation.Github
import androidx.core.net.toUri
import com.example.vigiform.navigation.LinkedinLogo
import com.example.vigiform.R

@Composable
fun AcercaDeScreen() {
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

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(0.8f)
            )

            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Icon(
                    imageVector = Instagram,
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
                    imageVector = LinkedinLogo,
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
                    imageVector = Github,
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