package com.example.vigiform.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import java.util.Locale

@Composable
fun DensidadScreen() {
    val focusManager = LocalFocusManager.current
    var mass by remember { mutableStateOf("") }
    var volume by remember { mutableStateOf("") }
    var density by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text = "Fórmula de la Densidad",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "ρ =", fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "m", fontSize = 24.sp)
                    HorizontalDivider(
                        modifier = Modifier
                            .width(40.dp)
                            .padding(vertical = 2.dp), thickness = 2.dp,
                        color = Color.Black
                    )
                    Text(text = "V", fontSize = 24.sp)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, top = 250.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "En dónde:",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "ρ  =  Densidad",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "m =  Masa",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "V  =  Volumen",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 375.dp, start = 35.dp, end = 35.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = mass,
                onValueChange = { newValue ->
                    if (newValue.length <= 8 && newValue.all { it.isDigit() || it == '.' }) {
                        mass = newValue
                    }
                },
                label = { Text(text = "Ingrese la Masa [kg]:") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = volume,
                onValueChange = { newValue ->
                    if (newValue.length <= 8 && newValue.all { it.isDigit() || it == '.' }) {
                        volume = newValue
                    }
                },
                label = { Text(text = "Ingrese el Volumen [m³]:") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            // Mostrar error o resultado de la densidad
            Spacer(modifier = Modifier.height(20.dp))

            density.let {
                if (it == "MISSING_MASS") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2)) // Rojo claro
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la masa.")
                    }
                } else if (it == "MISSING_VOLUME") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese el volumen.")
                    }
                } else if (it == "MISSING_BOTH") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la masa y el volumen.")
                    }
                } else if (it == "DIVISION_BY_ZERO") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No se puede dividir entre cero.")
                    }
                } else if (it.isNotEmpty()) {
                    Text(
                        text = "Densidad: $it [kg/m³]",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Botón para calcular la densidad
            Button(
                onClick = {
                    val masaValue = mass.toFloatOrNull()
                    val volumenValue = volume.toFloatOrNull()

                    density = when {
                        mass.isBlank() && volume.isBlank() -> "MISSING_BOTH"
                        mass.isBlank() -> "MISSING_MASS"
                        volume.isBlank() -> "MISSING_VOLUME"
                        volumenValue == 0f -> "DIVISION_BY_ZERO"
                        masaValue != null && volumenValue != null -> String.format(Locale.US, "%.3f", masaValue / volumenValue)
                        else -> "MISSING_BOTH"
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 92, green = 67, blue = 128),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Text(text = "Calcular Densidad")
            }
        }
    }
}

