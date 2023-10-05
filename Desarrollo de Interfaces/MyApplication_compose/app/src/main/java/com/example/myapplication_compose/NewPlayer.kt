package com.example.myapplication_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.red
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.myapplication_compose.ui.theme.azulNormal
import com.example.myapplication_compose.ui.theme.azulOscuro
import com.example.myapplication_compose.ui.theme.blanco
import com.example.myapplication_compose.ui.theme.cianBlanco

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newPlayer() {
    var nombre by rememberSaveable{ mutableStateOf("")}
    var apellidos by rememberSaveable{ mutableStateOf("")}
    var nickname by rememberSaveable{ mutableStateOf("")}
    var telefono by rememberSaveable{ mutableStateOf("")}
    var email by rememberSaveable{ mutableStateOf("")}
    var nombreObligatorio by rememberSaveable{ mutableStateOf(false) }
    var nickObligatorio by rememberSaveable{ mutableStateOf(false) }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.size(15.dp))
        Row {


            Image(painter = painterResource(id = R.drawable.account),
                contentDescription = "Usuario",
                Modifier.size(65.dp))
            TextField(value = nombre, onValueChange = {nombre = it},label ={Text(text ="Nombre"
                )}, colors = TextFieldDefaults.textFieldColors(
                    containerColor = cianBlanco,
                    focusedIndicatorColor = azulNormal
                ),shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
        }
        if(nombreObligatorio){
            Text(text = "Error: *Obligatorio", modifier = Modifier.padding(bottom = 15.dp, end = 25.dp),
                color = Color.Red)
        }else{
            Text(text = "*Obligatorio", modifier = Modifier.padding(bottom = 15.dp, end = 25.dp))

        }
        Row {
            Spacer(modifier = Modifier.size(65.dp))
            TextField(value = apellidos, onValueChange = {apellidos = it},label ={Text(text ="Apellidos")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cianBlanco,
                    focusedIndicatorColor = azulNormal), shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            )
        }
        Row {
            Spacer(modifier = Modifier.size(65.dp))
            TextField(value = nickname, onValueChange = {nickname = it},label ={Text(text ="Nickname")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cianBlanco,
                    focusedIndicatorColor = azulNormal),shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
        }
        if(nickObligatorio){
            Text(text = "Error: *Obligatorio", modifier = Modifier.padding(bottom = 15.dp, end = 25.dp),
                color = Color.Red)
        }else {
            Text(text = "*Obligatorio", modifier = Modifier.padding(bottom = 15.dp, end = 25.dp))

        }

        Spacer(modifier = Modifier.size(20.dp))
        Row {

            Image(painter = painterResource(id = R.drawable.android),
                contentDescription = "RobotAndroid",
                Modifier.size(120.dp))

            Spacer(modifier = Modifier.size(30.dp))
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = azulOscuro, contentColor = blanco),modifier = Modifier.width(150.dp)) {
                Text(
                    text = stringResource(id = R.string.change),
                    textAlign = TextAlign.Center,
                )
            }

        }
        Row {

            Image(painter = painterResource(id = R.drawable.camera),
                contentDescription = "Camera",
                Modifier.padding(top = 25.dp, start = 24.dp).size(65.dp))

            MyDropDownMenu()

        }
        Row {
            Image(painter = painterResource(id = R.drawable.email),
                contentDescription = "Email",
                Modifier.size(65.dp))
            TextField(value = email, onValueChange = {email = it},label ={Text(text ="Email")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cianBlanco,
                    focusedIndicatorColor = azulNormal)
                ,shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            )

        }
        
        Spacer(modifier = Modifier.size(20.dp))
        fun verificarNombre(){
            nombreObligatorio = nombre.isEmpty();
        }
        fun verificarNick(){
            nickObligatorio = nickname.isEmpty();
        }

        Button(onClick = {
                         verificarNombre();
                         verificarNick();
                         },
            colors = ButtonDefaults.buttonColors(containerColor = azulNormal, contentColor = blanco),modifier = Modifier.width(200.dp)) {
            Text(
                text = stringResource(id = R.string.addPlayer),
                textAlign = TextAlign.Center,
            )}
    }
    }
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val telefonos =
        listOf("666111111", "666222222", "666333333", "666444444", "666555555")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {
                selectedText = it
            },
            enabled = false,
            label =  { Text(text = "Teléfono")},
            readOnly = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = cianBlanco,
                focusedIndicatorColor = azulNormal),
            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
            modifier = Modifier
                .clickable { expanded = true }.fillMaxWidth()

        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },

        ) {
            telefonos.forEach { telefono ->

                DropdownMenuItem(
                    text = { Text(text = telefono)},
                    onClick = {
                    expanded = false
                    selectedText = telefono

                })
            }
        }
    }
}




