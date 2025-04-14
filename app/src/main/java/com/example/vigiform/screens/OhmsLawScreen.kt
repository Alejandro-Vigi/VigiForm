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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.vigiform.R

/**
 * ES: OhmsLawScreen es una función composable que permite al usuario calcular diferentes variables de la Ley de Ohm:
 * el voltaje (V), la corriente (I) o la resistencia (R), dependiendo de la fórmula seleccionada. Las fórmulas disponibles
 * son: V = I × R, I = V / R y R = V / I. La pantalla tiene campos de entrada para ingresar los valores necesarios y muestra
 * el resultado o un mensaje de error si faltan datos o si hay un error en el cálculo, como cuando la resistencia o la corriente
 * son cero, lo que causaría una división por cero. La pantalla también incluye un botón para realizar el cálculo y mostrar
 * los resultados o mensajes de error específicos.
 *
 * EN: OhmsLawScreen is a composable function that allows the user to calculate different variables of Ohm's Law:
 * voltage (V), current (I), or resistance (R), depending on the selected formula. The available formulas are:
 * V = I × R, I = V / R, and R = V / I. The screen has input fields to enter the necessary values and displays the result
 * or an error message if data is missing or if there is an error in the calculation, such as when resistance or current
 * are zero, which would cause a division by zero. The screen also includes a button to perform the calculation and display
 * the results or specific error messages.
 */

// Ohm error codes

private const val MISSING_CURRENT = "MISSING_CURRENT"
private const val MISSING_RESISTANCE = "MISSING_RESISTANCE"
private const val MISSING_VOLTAGE = "MISSING_VOLTAGE"
private const val MISSING_CURRENT_RESISTANCE = "MISSING_CURRENT_RESISTANCE"
private const val MISSING_VOLTAGE_RESISTANCE = "MISSING_VOLTAGE_RESISTANCE"
private const val MISSING_VOLTAGE_CURRENT = "MISSING_VOLTAGE_CURRENT"
private const val DIVISION_BY_ZERO = "DIVISION_BY_ZERO"

@Composable
fun OhmsLawScreen() {
    val formVoltage = stringResource(id = R.string.ohm_one)
    val formCurrent = stringResource(id = R.string.ohm_two)
    val resultCurrent = stringResource(id = R.string.result_current)
    val resultResistance = stringResource(id = R.string.result_resistance)
    val resultVoltage = stringResource(id = R.string.result_voltage)
    val formResistance = stringResource(id = R.string.ohm_three)
    val focusManager = LocalFocusManager.current
    var selectedForm by remember { mutableStateOf(formVoltage) }
    val forms = listOf(formVoltage, formCurrent, formResistance)
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
        Text(stringResource(id = R.string.form_ohm), fontSize = 24.sp)

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

        when (selectedForm) {
            stringResource(id = R.string.ohm_one) -> {
                TextField(
                    value = current,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) current = it },
                    label = { Text(stringResource(id = R.string.ohm_current)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = resistance,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) resistance = it },
                    label = { Text(stringResource(id = R.string.ohm_resistance)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            stringResource(id = R.string.ohm_two) -> {
                TextField(
                    value = voltage,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8 ) voltage = it },
                    label = { Text(stringResource(id = R.string.ohm_voltage)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = resistance,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) resistance = it },
                    label = { Text(stringResource(id = R.string.ohm_resistance)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            stringResource(id = R.string.ohm_three) -> {
                TextField(
                    value = voltage,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) voltage = it },
                    label = { Text(stringResource(id = R.string.ohm_voltage)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = current,
                    onValueChange = { if (it.all { c -> c.isDigit() || c == '.' } && it.length <= 8) current = it },
                    label = { Text(stringResource(id = R.string.ohm_current)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        result.let {
            if (it == MISSING_CURRENT) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(id = R.string.error_current))
                }
            } else if (it == MISSING_RESISTANCE) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(id = R.string.error_resistance))
                }
            } else if (it == MISSING_VOLTAGE) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(id = R.string.error_voltage))
                }
            } else if (it == MISSING_CURRENT_RESISTANCE) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                Text(stringResource(id = R.string.error_current_resistance))
                }
            } else if (it == MISSING_VOLTAGE_RESISTANCE) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(id = R.string.error_voltage_resistance))
                }
            } else if (it == MISSING_VOLTAGE_CURRENT) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2)) // Rojo claro
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(id = R.string.error_voltage_current))
                }
            } else if (it == DIVISION_BY_ZERO) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFCDD2)) // Rojo claro
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(id = R.string.division_by_zero))
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

        Button(
            onClick = {
                val voltageValue = voltage.toFloatOrNull()
                val currentValue = current.toFloatOrNull()
                val resistanceValue = resistance.toFloatOrNull()

                result = when (selectedForm) {
                    formVoltage  -> {
                        when {
                            current.isBlank() && resistance.isBlank() -> MISSING_CURRENT_RESISTANCE
                            current.isBlank() -> MISSING_CURRENT
                            resistance.isBlank() -> MISSING_RESISTANCE
                            currentValue != null && resistanceValue != null -> resultVoltage.format(currentValue * resistanceValue)
                            else -> MISSING_CURRENT_RESISTANCE
                        }
                    }

                    formCurrent -> {
                        when {
                            voltage.isBlank() && resistance.isBlank() -> MISSING_VOLTAGE_RESISTANCE
                            voltage.isBlank() -> MISSING_VOLTAGE
                            resistance.isBlank() -> MISSING_RESISTANCE
                            resistanceValue == 0f -> DIVISION_BY_ZERO
                            voltageValue != null && resistanceValue != null -> resultCurrent.format(
                                voltageValue.div(resistanceValue)
                            )
                            else -> MISSING_VOLTAGE_RESISTANCE
                        }
                    }

                    formResistance -> {
                        when {
                            voltage.isBlank() && current.isBlank() -> MISSING_VOLTAGE_CURRENT
                            voltage.isBlank() -> MISSING_VOLTAGE
                            current.isBlank() -> MISSING_CURRENT
                            currentValue == 0f -> DIVISION_BY_ZERO
                            voltageValue != null && currentValue != null -> resultResistance.format(
                                voltageValue.div(currentValue)
                            )
                            else -> MISSING_VOLTAGE_CURRENT
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
            Text(stringResource(id = R.string.calculate_ohm))
        }
    }
}