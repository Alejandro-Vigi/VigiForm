package com.example.vigiform.screens

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import com.example.vigiform.navigation.Github
import androidx.core.net.toUri
import com.example.vigiform.navigation.LinkedinLogo

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pantalla AcercaDe",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Version de la aplicacion: 1.0",
                fontSize = 30.sp
            )
            Text(
                text = "2025",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Icon(
                imageVector = Instagram,
                contentDescription = "Instagram Icon",
                modifier = Modifier
                    .size(48.dp)
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
                    .size(48.dp)
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
                    .size(48.dp)
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