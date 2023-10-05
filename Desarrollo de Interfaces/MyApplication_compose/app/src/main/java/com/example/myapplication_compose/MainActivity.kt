package com.example.myapplication_compose


import about
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Preferences
import com.example.myapplication_compose.ui.theme.MyApplication_composeTheme
import com.example.myapplication_compose.ui.theme.games

import java.util.prefs.Preferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()){
                    
                    val navController = rememberNavController();
                    NavHost(navController = navController, startDestination = "Portada"){
                        composable("Portada"){ Portada(navController)}
                        composable("NewPlayer"){ newPlayer()}
                        composable("Preferences"){ Preferences() }
                        composable("Games"){ games() }
                        composable("About"){ about()}
                    }
                }
            }
        }
    }
}

