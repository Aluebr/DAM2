package com.example.myapplication_compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication_compose.ui.theme.courgetteRegular

@Composable
fun Portada(navController:NavHostController) {

    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription ="Logo",
                    modifier = Modifier.size(120.dp) )

                Text(
                    text = stringResource(id = R.string.playJuegos),
                    fontFamily = courgetteRegular,
                    fontStyle = FontStyle.Italic,
                    fontSize = 50.sp
                )
                Spacer(modifier = Modifier.height(50.dp))
                Row {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(200.dp)
                            .padding(end = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.play),
                            textAlign = TextAlign.Center,

                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(200.dp)
                            .padding(end = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.preferences),
                            textAlign = TextAlign.Center,

                        )
                    }
                }

                Row {
                    Button(
                        onClick = { navController.navigate("NewPlayer") },
                        modifier = Modifier
                            .width(200.dp)
                            .padding(end = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.newPlayer),
                            textAlign = TextAlign.Center,

                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(200.dp)
                            .padding(end = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.about),
                            textAlign = TextAlign.Center,

                        )
                    }
                }
            }
        }

        else -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription ="Logo" )
                Text(
                    text = stringResource(id = R.string.playJuegos),
                    fontFamily = courgetteRegular,
                    fontStyle = FontStyle.Italic,
                    fontSize = 50.sp
                )
                Spacer(modifier = Modifier.height(50.dp))

                Button(onClick = { navController.navigate("Games") }, modifier = Modifier.width(200.dp)) {
                    Text(
                        text = stringResource(id = R.string.play),
                        textAlign = TextAlign.Center,

                    )
                }

                Button(onClick = { navController.navigate("NewPlayer") }, modifier = Modifier.width(200.dp)) {
                    Text(
                        text = stringResource(id = R.string.newPlayer),
                        textAlign = TextAlign.Center,

                    )
                }

                Button(onClick = { navController.navigate("Preferences")  }, modifier = Modifier.width(200.dp)) {
                    Text(
                        text = stringResource(id = R.string.preferences),
                        textAlign = TextAlign.Center,

                    )
                }

                Button(onClick = { navController.navigate("About") }, modifier = Modifier.width(200.dp)) {
                    Text(
                        text = stringResource(id = R.string.about),
                        textAlign = TextAlign.Center,

                    )
                }

            }
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication_composeTheme {
        Greeting("Android")
    }
}*/