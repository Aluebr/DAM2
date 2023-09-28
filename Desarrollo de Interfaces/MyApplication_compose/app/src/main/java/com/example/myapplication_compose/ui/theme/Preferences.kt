package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication_compose.ui.theme.azulOscuro

@Composable
fun Preferences() {

    var estadoRadio by rememberSaveable { mutableStateOf<String?>(null) }
    var puntuacion by remember { mutableStateOf(0f) }
    var currentRating by remember { mutableStateOf(0.0) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Elige una opción:",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            MyRadioButton(estadoRadio) { selectedOption ->
                estadoRadio = selectedOption
            }
            Slider(puntuacion) { sliderValue ->
                puntuacion = sliderValue
            }
            RatingBar(
                rating = currentRating,
                onRatingChanged = { newRating -> currentRating = newRating })

            FilterChips()

        }
        StartsFab(estadoRadio, currentRating)
        FloatingActionButton(estadoRadio, puntuacion)
    }
}

@Composable
fun MyRadioButton(estadoRadio: String?, onOptionSelected: (String) -> Unit) {
    Row() {
        RadioButton(
            selected = estadoRadio == "Angry Birds",
            onClick = { onOptionSelected("Angry Birds") })
        Text(
            text = "Angry Birds",
            Modifier.padding(top = 12.dp)
        )
    }
    Row() {
        RadioButton(
            selected = estadoRadio == "Dragon Fly",
            onClick = { onOptionSelected("Dragon Fly") }
        )
        Text(
            text = "Dragon Fly",
            Modifier.padding(top = 12.dp)
        )
    }
    Row() {
        RadioButton(
            selected = estadoRadio == "Hill Climbing Racing",
            onClick = { onOptionSelected("Hill Climbing Racing") })
        Text(
            text = "Hill Climbing Racing",
            Modifier.padding(top = 12.dp)
        )
    }
    Row() {
        RadioButton(
            selected = estadoRadio == "Pocket Soccer",
            onClick = { onOptionSelected("Pocket Soccer") }
        )
        Text(
            text = "Pocket Soccer",
            Modifier.padding(top = 12.dp)
        )
    }
    Row() {
        RadioButton(
            selected = estadoRadio == "Radiant Defense",
            onClick = { onOptionSelected("Radiant Defense") }
        )
        Text(
            text = "Radiant Defense",
            Modifier.padding(top = 12.dp)
        )
    }
    Row() {
        RadioButton(
            selected = estadoRadio == "Ninja Jump",
            onClick = { onOptionSelected("Ninja Jump") }
        )
        Text(
            text = "Ninja Jump",
            Modifier.padding(top = 12.dp)
        )
    }
    Row() {
        RadioButton(
            selected = estadoRadio == "Air Control",
            onClick = { onOptionSelected("Air Control") }
        )
        Text(
            text = "Air Control",
            Modifier.padding(top = 12.dp)
        )
    }
}

@Composable
fun Slider(puntuacion: Float, onSliderValueChanged: (Float) -> Unit) {
    val range = 0.0f..10.0f
    val steps = 10
    var selection by remember { mutableStateOf(puntuacion) }
    Slider(
        value = selection,
        valueRange = range,
        steps = steps,
        onValueChange = {
            selection = it
            onSliderValueChanged(it)
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun FloatingActionButton(estadoRadio: String?, puntuacion: Float) {
    var context = LocalContext.current
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        ExtendedFloatingActionButton(
            content = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                )
            },
            onClick = {
                if (estadoRadio != null) {
                    Toast.makeText(
                        context,
                        "Has seleccionado $estadoRadio con una puntuación de $puntuacion",
                        Toast.LENGTH_LONG
                    )
                        .show()
                } else {
                    Toast.makeText(context, "No has pulsado ninguna opción", Toast.LENGTH_LONG)
                        .show()
                }
            },
            containerColor = azulOscuro,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips() {

    var estadoRadio2 by rememberSaveable { mutableStateOf<String?>(null) }

    var context = LocalContext.current
    var selectedPS4 by remember { mutableStateOf(false) }
    var selected3DS by remember { mutableStateOf(false) }
    var selectedXBOX by remember { mutableStateOf(false) }
    var selectedWII by remember { mutableStateOf(false) }
    var selectedWIIU by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Plataformas:",
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )
        Row {
            FilterChip(
                onClick = {
                    selectedPS4 = !selectedPS4; selected3DS = false; selectedWII =
                    false; selectedXBOX = false; selectedWIIU = false
                    Toast.makeText(context, "Has seleccionado PS4", Toast.LENGTH_LONG)
                        .show()
                },
                label = {
                    Text("PS4")
                },
                selected = selectedPS4,
                leadingIcon = if (selectedPS4) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier
                                .size(FilterChipDefaults.IconSize)
                                .padding(2.dp)
                        )
                    }
                } else {
                    null
                },
            )

            FilterChip(
                onClick = {
                    selectedXBOX = !selectedXBOX; selected3DS = false; selectedWII =
                    false; selectedPS4 = false; selectedWIIU = false
                    Toast.makeText(context, "Has seleccionado XBOX", Toast.LENGTH_LONG)
                        .show()
                },
                label = {
                    Text("XBOX")
                },
                selected = selectedXBOX,
                leadingIcon = if (selectedXBOX) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier
                                .size(FilterChipDefaults.IconSize)
                                .padding(2.dp)
                        )
                    }
                } else {
                    null
                },
            )

            FilterChip(
                onClick = {
                    selected3DS = !selected3DS; selectedPS4 = false; selectedWII =
                    false; selectedXBOX = false; selectedWIIU = false
                    Toast.makeText(context, "Has seleccionado 3DS", Toast.LENGTH_LONG)
                        .show()
                },
                label = {
                    Text("3DS")
                },
                selected = selected3DS,
                leadingIcon = if (selected3DS) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier
                                .size(FilterChipDefaults.IconSize)
                                .padding(2.dp)
                        )
                    }
                } else {
                    null
                },
            )

            FilterChip(
                onClick = {
                    selectedWII = !selectedWII; selectedPS4 = false; selected3DS =
                    false; selectedXBOX = false; selectedWIIU = false
                    Toast.makeText(context, "Has seleccionado WII", Toast.LENGTH_LONG)
                        .show()
                },
                label = {
                    Text("WII")
                },
                selected = selectedWII,
                leadingIcon = if (selectedWII) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier
                                .size(FilterChipDefaults.IconSize)
                                .padding(2.dp)
                        )
                    }
                } else {
                    null
                },
            )

            FilterChip(
                onClick = {
                    selectedWIIU = !selectedWIIU; selectedPS4 = false; selectedWII =
                    false; selectedXBOX = false; selected3DS = false
                    Toast.makeText(context, "Has seleccionado WIIU", Toast.LENGTH_LONG)
                        .show()
                },
                label = {
                    Text("WIIU")
                },
                selected = selectedWIIU,
                leadingIcon = if (selectedWIIU) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier
                                .size(FilterChipDefaults.IconSize)
                                .padding(2.dp)
                        )
                    }
                } else {
                    null
                },
            )
        }
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 10,
    starsColor: Color = Color.Gray,
    onRatingChanged: (Double) -> Unit
) {
    val filledStars = rating.toInt()
    val halfStar = rating - filledStars >= 0.5f
    val starColorFilled: Color = Color.Yellow
    Row(modifier = modifier) {
        for (i in 0 until filledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = starColorFilled,
                modifier = Modifier.clickable {
                    onRatingChanged(i + 1.0)
                }
            )
            Spacer(modifier = Modifier.width(12.dp))

        }

        if (halfStar) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = starColorFilled,
                modifier = Modifier.clickable {
                    onRatingChanged(filledStars + 0.5)
                }
            )
            Spacer(modifier = Modifier.width(10.dp))

        }

        for (i in filledStars + (if (halfStar) 1 else 0) until stars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = starsColor,
                modifier = Modifier.clickable {
                    onRatingChanged(i + 1.0)
                }
            )
            Spacer(modifier = Modifier.width(12.dp))

        }
    }
}

@Composable
fun StartsFab(estadoRadio: String?, currentRating: Double) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .offset(300.dp, 580.dp),

    ) {
        FloatingActionButton(
            onClick = {
                val message = if (estadoRadio != null) {
                    "Has seleccionado: $estadoRadio con una puntuación de $currentRating estrellas."
                } else {
                    "No has seleccionado ningún juego"
                }

                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}