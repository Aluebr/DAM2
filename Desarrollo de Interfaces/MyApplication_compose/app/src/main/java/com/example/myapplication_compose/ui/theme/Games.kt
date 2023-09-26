package com.example.myapplication_compose.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication_compose.CheckInfo
import com.example.myapplication_compose.R

val photoList = listOf(R.drawable.games_angrybirds,R.drawable.games_dragonfly,
    R.drawable.games_hillclimbingracing,R.drawable.games_radiantdefense,
    R.drawable.games_pocketsoccer,R.drawable.games_ninjump,
    R.drawable.games_aircontrol)

var estadoRadio = "";
@Composable
fun MyCheckBox(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Image(painter = painterResource(id = checkInfo.imagen), contentDescription = checkInfo.imagen.toString() ,  Modifier.size(70.dp))
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {
                checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)



    }
}

@Composable
fun getOptions(titles: List<String>, imagen: List<Int>): List<CheckInfo> {
    val checkInfos = mutableListOf<CheckInfo>()

    titles.forEachIndexed { index, title ->
        var estadoCheck by rememberSaveable {
            mutableStateOf(false)
        }

        checkInfos.add(
            CheckInfo(
                title = title,
                selected = estadoCheck,
                onCheckedChange = { estadoCheck = it },
                imagen = imagen.getOrElse(index) { R.drawable.account } // Imagen predeterminada si no hay imagen en la lista
            )
        )
    }

    return checkInfos
}

@Composable
fun games() {

    Column(
        modifier = Modifier.fillMaxSize(),

    ) {
        Spacer(modifier = Modifier.size(10.dp))

        Spacer(modifier = Modifier.size(20.dp))

        val myOptions = getOptions(listOf("Angry Birds", "Dragon Fly",
            "Hill Climbing Racing", "Radiant Defense",
            "Pocket Soccer", "Ninja Jump", "Air Control"), photoList)
        Column() {
            myOptions.forEach {
                MyCheckBox(it)

            }
        }
    }
    FAB();
}
@Composable
fun FAB() {
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
