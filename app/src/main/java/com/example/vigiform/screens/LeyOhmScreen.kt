package com.example.vigiform.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign


@Composable
fun LeyOhmScreen() {
    val focusManager = LocalFocusManager.current
    var selectedForm by remember { mutableStateOf("V = I × R") }
    val forms = listOf("V = I × R", "I = V / R", "R = V / I")
    var expanded by remember { mutableStateOf(false) }
    var voltage by remember { mutableStateOf("") }
    var current by remember { mutableStateOf("") }
    var resistance by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .pointerInput(Unit) {
                detectTapGestures { focusManager.clearFocus() }
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text("Fórmulas Ley de Ohm", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Box {
            Button(
                onClick = { expanded = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 92, green = 67, blue = 128),
                    contentColor = Color.White
                )
            ) {
                Text(selectedForm)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                forms.forEach { formula ->
                    DropdownMenuItem(
                        text = { Text(formula) },
                        onClick = {
                            selectedForm = formula
                            expanded = false
                            voltage = ""
                            current = ""
                            resistance = ""
                            result = ""
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Campos según fórmula seleccionada
        when (selectedForm) {
            "V = I × R" -> {
                TextField(
                    value = current,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) current = it },
                    label = { Text("Corriente [A]") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = resistance,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) resistance = it },
                    label = { Text("Resistencia [Ω]") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            "I = V / R" -> {
                TextField(
                    value = voltage,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8 ) voltage = it },
                    label = { Text("Voltaje [V]") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = resistance,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) resistance = it },
                    label = { Text("Resistencia [Ω]") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            "R = V / I" -> {
                TextField(
                    value = voltage,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) voltage = it },
                    label = { Text("Voltaje [V]") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = current,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) current = it },
                    label = { Text("Corriente [A]") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        result.let {
            if (it == "MISSING_CURRENT") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Por favor, ingrese la corriente.")
                }
            } else if (it == "MISSING_RESISTANCE") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Por favor, ingrese la resistencia.")
                }
            } else if (it == "MISSING_VOLTAGE") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Por favor, ingrese el voltaje.")
                }
            } else if (it == "MISSING_CURRENT_RESISTANCE") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2)) // Rojo claro
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                Text("Por favor, ingrese la corriente y la resistencia.")
                }
            } else if (it == "MISSING_VOLTAGE_RESISTANCE") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2)) // Rojo claro
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Por favor, ingrese el voltaje y la resistencia.")
                }
            } else if (it == "MISSING_VOLTAGE_CURRENT") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2)) // Rojo claro
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Por favor, ingrese el voltaje y la corriente.")
                }
            } else if (it == "DIVISION_BY_ZERO") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2)) // Rojo claro
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No se puede dividir entre cero.")
                }
            } else if (it.isNotEmpty()) {
                Text(
                    text = it,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        // Botón de calcular
        Button(
            onClick = {
                val voltageValue = voltage.toFloatOrNull()
                val currentValue = current.toFloatOrNull()
                val resistanceValue = resistance.toFloatOrNull()

                result = when (selectedForm) {
                    "V = I × R" -> {
                        when {
                            current.isBlank() && resistance.isBlank() -> "MISSING_CURRENT_RESISTANCE"
                            current.isBlank() -> "MISSING_CURRENT"
                            resistance.isBlank() -> "MISSING_RESISTANCE"
                            currentValue != null && resistanceValue != null -> "Voltaje = %.2f [V]".format(currentValue * resistanceValue)
                            else -> "MISSING_CURRENT_RESISTANCE"
                        }
                    }

                    "I = V / R" -> {
                        when {
                            voltage.isBlank() && resistance.isBlank() -> "MISSING_VOLTAGE_RESISTANCE"
                            voltage.isBlank() -> "MISSING_VOLTAGE"
                            resistance.isBlank() -> "MISSING_RESISTANCE"
                            resistanceValue == 0f -> "DIVISION_BY_ZERO"
                            voltageValue != null && resistanceValue != null -> "Corriente = %.2f [A]".format(
                                voltageValue.div(resistanceValue)
                            )
                            else -> "MISSING_VOLTAGE_RESISTANCE"
                        }
                    }

                    "R = V / I" -> {
                        when {
                            voltage.isBlank() && current.isBlank() -> "MISSING_VOLTAGE_CURRENT"
                            voltage.isBlank() -> "MISSING_VOLTAGE"
                            current.isBlank() -> "MISSING_CURRENT"
                            currentValue == 0f -> "DIVISION_BY_ZERO"
                            voltageValue != null && currentValue != null -> "Resistencia = %.2f [Ω]".format(
                                voltageValue.div(currentValue)
                            )
                            else -> "MISSING_VOLTAGE_CURRENT"
                        }
                    }
                    else -> ""
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(red = 92, green = 67, blue = 128),
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Calcular")
        }
    }
}