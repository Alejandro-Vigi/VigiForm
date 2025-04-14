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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vigiform.R
import java.util.Locale

/**
 * ES: KineticEnergyScreen es una función composable que permite al usuario calcular la energía cinética de un objeto
 * a partir de su masa y velocidad. La fórmula utilizada es: Eₖ = 1/2 * m * v², donde Eₖ es la energía cinética en julios,
 * m es la masa del objeto en kilogramos y v es la velocidad del objeto en metros por segundo. La pantalla tiene campos
 * para ingresar la masa y la velocidad, y muestra el resultado de la energía cinética o un mensaje de error si faltan
 * datos o hay errores en el cálculo, como cuando uno o ambos campos están vacíos. También incluye un botón para realizar
 * el cálculo y mostrar los resultados o los mensajes de error específicos.
 *
 * EN: KineticEnergyScreen is a composable function that allows the user to calculate the kinetic energy of an object
 * based on its mass and velocity. The formula used is: Eₖ = 1/2 * m * v², where Eₖ is the kinetic energy in joules,
 * m is the object's mass in kilograms, and v is the object's velocity in meters per second. The screen has fields to
 * input the mass and velocity, and displays the result of the kinetic energy or an error message if data is missing
 * or there are calculation errors, such as when one or both fields are empty. It also includes a button to perform
 * the calculation and display the results or specific error messages.
 */

// KineticEnergy error codes

private const val MISSING_BOTH = "MISSING_BOTH"
private const val MISSING_MASS = "MISSING_MASS"
private const val MISSING_VELOCITY = "MISSING_VELOCITY"

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
                text = stringResource(id = R.string.form_kinetic_energy),
                fontSize = 26.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.kinetic_letter), fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Text(text = stringResource(id = R.string.equal), fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(id = R.string.one), fontSize = 24.sp)
                    HorizontalDivider(
                        modifier = Modifier
                            .width(40.dp)
                            .padding(vertical = 2.dp), thickness = 2.dp,
                        color = colorResource(id = R.color.black)
                    )
                    Text(text = stringResource(id = R.string.two), fontSize = 24.sp)
                }
                Text(text = stringResource(id = R.string.mv2), fontSize = 28.sp, modifier = Modifier.padding(end = 8.dp))
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
                text = stringResource(id = R.string.kinetic),
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.kinetic_mass),
                Modifier.padding(start = 25.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.kinetic_velocity),
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
                label = { Text(stringResource(id = R.string.input_kinetic_mass)) },
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
                label = { Text(stringResource(id = R.string.input_kinetic_velocity)) },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            result.let {
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
                } else if (it == MISSING_VELOCITY) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.red_error))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stringResource(id = R.string.error_velocity))
                    }
                } else if (it == MISSING_BOTH) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.red_error))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stringResource(id = R.string.error_mass_velocity))
                    }
                } else if (it.isNotEmpty()) {
                    Text(
                        text = stringResource(id = R.string.kinetic_result, it),
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
                    val masaValue = mass.toFloatOrNull()
                    val velocityValue = velocity.toFloatOrNull()

                    result = when {
                        mass.isBlank() && velocity.isBlank() -> MISSING_BOTH
                        mass.isBlank() -> MISSING_MASS
                        velocity.isBlank() -> MISSING_VELOCITY
                        masaValue != null && velocityValue != null -> String.format(Locale.US, "%.3f", 0.5 * masaValue * (velocityValue * velocityValue))
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
                Text(text = stringResource(id = R.string.calculate_kinetic))
            }
        }
    }
}