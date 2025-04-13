package com.example.vigiform.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun KineticEnergyScreen() {
    val focusManager = LocalFocusManager.current
    var mass by remember { mutableStateOf("") }
    var velocity by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

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
                text = "Fórmula de la Energía Cinética",
                fontSize = 26.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Eₖ", fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Text(text = "=", fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "1", fontSize = 24.sp)
                    HorizontalDivider(
                        modifier = Modifier
                            .width(40.dp)
                            .padding(vertical = 2.dp), thickness = 2.dp,
                        color = Color.Black
                    )
                    Text(text = "2", fontSize = 24.sp)
                }
                Text(text = "mv²", fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
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
                text = "E  = Energía cinética",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "m = Masa",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "v  = Velocidad",
                Modifier.padding(start = 27.dp),
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
                value = velocity,
                onValueChange = { newValue ->
                    if (newValue.length <= 8 && newValue.all { it.isDigit() || it == '.' }) {
                        velocity = newValue
                    }
                },
                label = { Text(text = "Ingrese la Velocidad [m/s]:") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            // Mostrar error o resultado de la densidad
            Spacer(modifier = Modifier.height(20.dp))

            result.let {
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
                } else if (it == "MISSING_VELOCITY") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la velocidad.")
                    }
                } else if (it == "MISSING_BOTH") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la masa y la velocidad.")
                    }
                } else if (it.isNotEmpty()) {
                    Text(
                        text = "Energía cinética: $it [J]",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Botón para calcular la densidad
            Button(
                onClick = {
                    val masaValue = mass.toFloatOrNull()
                    val velocityValue = velocity.toFloatOrNull()

                    result = when {
                        mass.isBlank() && velocity.isBlank() -> "MISSING_BOTH"
                        mass.isBlank() -> "MISSING_MASS"
                        velocity.isBlank() -> "MISSING_VELOCITY"
                        masaValue != null && velocityValue != null -> String.format(Locale.US, "%.3f", 0.5 * masaValue * (velocityValue * velocityValue))
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
                Text(text = "Calcular Energía Cinética")
            }
        }
    }
}