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

/**
 * ES: DosageScreen es una función composable que permite al usuario calcular la dosis de un fármaco para un animal
 * a partir de tres parámetros: la dosis requerida por kg, la concentración del fármaco y el peso del animal.
 * La fórmula utilizada para el cálculo de la dosis es: D = (Dᵣ / Cᶠ) * m, donde D es la dosis de fármaco en mL,
 * Dᵣ es la dosis requerida en mg/kg, Cᶠ es la concentración del fármaco en mg/mL y m es la masa del animal en kg.
 * La pantalla tiene campos para ingresar estos tres valores, y muestra el resultado de la dosis calculada o un mensaje de
 * error si falta algún dato o hay errores en el cálculo. También incluye un botón para realizar el cálculo y mostrar los errores
 * específicos, como campos vacíos o división por cero.
 *
 * EN: DosageScreen is a composable function that allows the user to calculate the drug dose for an animal based on three parameters:
 * the required dose per kg, the drug concentration, and the animal's weight. The formula used for the dose calculation is:
 * D = (Dᵣ / Cᶠ) * m, where D is the drug dose in mL, Dᵣ is the required dose in mg/kg, Cᶠ is the drug concentration in mg/mL,
 * and m is the animal's weight in kg. The screen has fields to input these three values and displays the calculated dose result or
 * an error message if any data is missing or there are calculation errors. It also includes a button to perform the calculation
 * and display specific errors, such as missing fields or division by zero.
 */

@Composable
fun DosageScreen() {
    val focusManager = LocalFocusManager.current
    var requiredDosePerKg by remember { mutableStateOf("") }
    var drugConcentration by remember { mutableStateOf("") }
    var animalWeight by remember { mutableStateOf("") }
    var drugDose by remember { mutableStateOf("") }

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
                text = "Fórmula de la Dosis de Fármaco",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "D", fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Text(text = "=", fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Dᵣ", fontSize = 24.sp)
                    HorizontalDivider(
                        modifier = Modifier
                            .width(40.dp)
                            .padding(vertical = 2.dp), thickness = 2.dp,
                        color = Color.Black
                    )
                    Text(text = "Cᶠ", fontSize = 24.sp)
                }
                Text(text = "m", fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
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
                text = "D  = Dosis de fármaco",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Dᵣ = Dosis requerida",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Cᶠ = Concentración del fármaco",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "m = Masa del animal",
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 395.dp, start = 35.dp, end = 35.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = requiredDosePerKg,
                onValueChange = { newValue ->
                    if (newValue.length <= 8 && newValue.all { it.isDigit() || it == '.' }) {
                        requiredDosePerKg = newValue
                    }
                },
                label = { Text(text = "Ingrese la Dosis requerida [mg/kg]:") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = drugConcentration,
                onValueChange = { newValue ->
                    if (newValue.length <= 8 && newValue.all { it.isDigit() || it == '.' }) {
                        drugConcentration = newValue
                    }
                },
                label = { Text(text = "Ingrese la Concentración del fármaco [mg/ml]:") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = animalWeight,
                onValueChange = { newValue ->
                    if (newValue.length <= 8 && newValue.all { it.isDigit() || it == '.' }) {
                        animalWeight = newValue
                    }
                },
                label = { Text(text = "Ingrese la Masa del animal [kg]:") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            drugDose.let {
                if (it == "MISSING_DOSEPERKG") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2)) // Rojo claro
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la dosis requerida.")
                    }
                } else if (it == "MISSING_DRUGCONCENTRATION") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la concentración del fármaco.")
                    }
                } else if (it == "MISSING_DOSEPERKG_DRUGCONCENTRATION") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la dosis requerida y la concentración del fármaco.")
                    }
                } else if (it == "MISSING_DOSEPERKG_ANIMALWEIGHT") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la dosis requerida y la masa del animal.")
                    }
                } else if (it == "MISSING_DRUGCONCENTRATION_ANIMALWEIGHT") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la concentración del fármaco y la masa del animal.")
                    }
                } else if (it == "MISSING_ANIMALWEIGHT") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la masa del animal.")
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
                } else if (it == "MISSING_BOTH") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFFCDD2))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Por favor, ingrese la dosis requerida, la concentración del fármaco y la masa del animal.")
                    }
                } else if (it.isNotEmpty()) {
                    Text(
                        text = "Dosis de fármaco: $it [mL]",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = {
                    val requiredDosePerKgValue = requiredDosePerKg.toFloatOrNull()
                    val drugConcentrationValue = drugConcentration.toFloatOrNull()
                    val animalWeightValue = animalWeight.toFloatOrNull()

                    drugDose = when {
                        requiredDosePerKg.isBlank() && drugConcentration.isBlank() && animalWeight.isBlank() -> "MISSING_BOTH"
                        requiredDosePerKg.isBlank() && drugConcentration.isBlank() -> "MISSING_DOSEPERKG_DRUGCONCENTRATION"
                        requiredDosePerKg.isBlank() && animalWeight.isBlank() -> "MISSING_DOSEPERKG_ANIMALWEIGHT"
                        drugConcentration.isBlank() && animalWeight.isBlank() -> "MISSING_DRUGCONCENTRATION_ANIMALWEIGHT"
                        requiredDosePerKg.isBlank() -> "MISSING_DOSEPERKG"
                        drugConcentration.isBlank() -> "MISSING_DRUGCONCENTRATION"
                        animalWeight.isBlank() -> "MISSING_ANIMALWEIGHT"
                        drugConcentrationValue == 0f -> "DIVISION_BY_ZERO"
                        requiredDosePerKgValue != null && drugConcentrationValue != null && animalWeightValue != null -> String.format(Locale.US, "%.3f", (requiredDosePerKgValue/drugConcentrationValue)*animalWeightValue)
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
                Text(text = "Calcular Dosis de Fármaco")
            }
        }
    }
}