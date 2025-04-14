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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.vigiform.R
import java.util.Locale

/**
 * ES: DensityScreen es una función composable que permite al usuario calcular la densidad de un objeto
 * a partir de su masa y volumen. La fórmula utilizada es: ρ = m / V, donde ρ es la densidad, m es la masa
 * y V es el volumen. La pantalla tiene campos para ingresar la masa y el volumen, y muestra el resultado
 * de la densidad o un mensaje de error si faltan datos o hay errores en el cálculo. También se incluye un
 * botón para realizar el cálculo.
 *
 * EN: DensityScreen is a composable function that allows the user to calculate the density of an object
 * based on its mass and volume. The formula used is: ρ = m / V, where ρ is the density, m is the mass,
 * and V is the volume. The screen has fields to enter the mass and volume, and displays the result of the
 * density or an error message if data is missing or there are calculation errors. There is also a button
 * to perform the calculation.
 */

// Density error codes

private const val MISSING_MASS = "MISSING_MASS"
private const val MISSING_VOLUME = "MISSING_VOLUME"
private const val MISSING_BOTH = "MISSING_BOTH"
private const val DIVISION_BY_ZERO = "DIVISION_BY_ZERO"

@Composable
fun DensityScreen() {
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
                text = stringResource(id = R.string.form_density),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.density_letter), fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(id = R.string.mass_leter), fontSize = 24.sp)
                    HorizontalDivider(
                        modifier = Modifier
                            .width(40.dp)
                            .padding(vertical = 2.dp), thickness = 2.dp,
                        color = colorResource(id = R.color.black)
                    )
                    Text(text = stringResource(id = R.string.volume_letter), fontSize = 24.sp)
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
                text = stringResource(id = R.string.label_where),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.density_screen),
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.mass),
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.volume),
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
                label = { Text(stringResource(id = R.string.input_mass)) },
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
                label = { Text(stringResource(id = R.string.input_volume)) },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            density.let {
                if (it == MISSING_MASS) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.red_error))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stringResource(id = R.string.error_mass))
                    }
                } else if (it == MISSING_VOLUME) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.red_error))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stringResource(id = R.string.error_volume))
                    }
                } else if (it == MISSING_BOTH) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.red_error))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stringResource(id = R.string.error_mass_volume))
                    }
                } else if (it == DIVISION_BY_ZERO) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.red_error))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stringResource(id = R.string.division_by_zero))
                    }
                } else if (it.isNotEmpty()) {
                    Text(
                        text = stringResource(R.string.density_result, it),
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = {
                    val masaValue = mass.toFloatOrNull()
                    val volumenValue = volume.toFloatOrNull()

                    density = when {
                        mass.isBlank() && volume.isBlank() -> MISSING_BOTH
                        mass.isBlank() -> MISSING_MASS
                        volume.isBlank() -> MISSING_VOLUME
                        volumenValue == 0f -> DIVISION_BY_ZERO
                        masaValue != null && volumenValue != null -> String.format(Locale.US, "%.3f", masaValue / volumenValue)
                        else -> MISSING_BOTH
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_dark),
                    contentColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.calculate_density))
            }
        }
    }
}