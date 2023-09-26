package com.example.myapplication_compose.ui.theme

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun preferences() {
    var selection by rememberSaveable { mutableStateOf(50f) }
    var puntuacion by rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = "Elige una opción: ",
            textAlign = TextAlign.Center
        )
    }

    myRadioButton();


}

@Composable
fun myRadioButton() {
    var estadoRadio by rememberSaveable { mutableStateOf("") }


    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(40.dp))

        Row() {
            RadioButton(selected = estadoRadio == "Angry Birds", onClick
            = { estadoRadio = "Angry Birds" })
            Text(text = "Angry Birds", Modifier.padding(top = 12.dp))
        }
        Row {
            RadioButton(selected = estadoRadio == "Dragon Fly", onClick
            = { estadoRadio = "Dragon Fly" })
            Text(text = "Dragon Fly", Modifier.padding(top = 12.dp))
        }
        Row {


            RadioButton(selected = estadoRadio == "Hill Climbing Racing", onClick
            = { estadoRadio = "Hill Climbing Racing" })
            Text(text = "Hill Climbing Racing", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = estadoRadio == "Pocket Soccer", onClick
            = { estadoRadio = "Pocket Soccer" })
            Text(text = "Pocket Soccer", Modifier.padding(top = 12.dp))
        }
        Row {
            RadioButton(selected = estadoRadio == "Radiant Defense", onClick
            = { estadoRadio = "Radiant Defense" })
            Text(text = "Radiant Defense", Modifier.padding(top = 12.dp))
        }
        Row {
            RadioButton(selected = estadoRadio == "Ninja Jump", onClick
            = { estadoRadio = "Ninja Jump" })
            Text(text = "Ninja Jump", Modifier.padding(top = 12.dp))
        }
        Row {
            RadioButton(selected = estadoRadio == "Air Control", onClick
            = { estadoRadio = "Air Control" })
            Text(text = "Air Control", Modifier.padding(top = 12.dp))
        }

        Row {
            FABAlwaysBottomRight(estadoRadio)
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun filterChips() {

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
                            modifier = Modifier.size(FilterChipDefaults.IconSize).padding(2.dp)
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
                            modifier = Modifier.size(FilterChipDefaults.IconSize).padding(2.dp)
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
                            modifier = Modifier.size(FilterChipDefaults.IconSize).padding(2.dp)
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
                            modifier = Modifier.size(FilterChipDefaults.IconSize).padding(2.dp)
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
                            modifier = Modifier.size(FilterChipDefaults.IconSize).padding(2.dp)
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
fun FABAlwaysBottomRight(estadoRadio: String) {
    val range = 0f..10f
    val steps = 10
    var selection by rememberSaveable { mutableStateOf(5f) }

    Box(
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Slider(
                value = selection,
                valueRange = range,
                steps = steps,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                onValueChange = { selection = it }
            )


            Spacer(modifier = Modifier.height(25.dp))
            Row {
                filterChips()
            }
        }

        var context = LocalContext.current
        FloatingActionButton(
            onClick = {
                var message = if (estadoRadio.isNotEmpty()) {
                    "Has seleccionado $estadoRadio \n Puntuación: $selection"
                } else {
                    "No has seleccionado nada "
                }
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            },
            containerColor = azulOscuro,
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
                .align(Alignment.BottomEnd)
                
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Check"
            )
        }
    }
}



