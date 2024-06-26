package pe.edu.upc.superherocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.superherocompose.ui.home.Home
import pe.edu.upc.superherocompose.ui.theme.SuperHeroComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}


/*avanzar la parte de lazyColumn, completa el diseno, colocar image, nombre, nombre real
* y todo, con barra de busqueda y corazon
* solo diseno a mas
* */


/* BIBLIOTECAS
* retrofit
* converter-gson
* landscapist-glide
* (room)
* */


/*
* Navigation Compose
* navigation-compose*/
