package pe.edu.upc.superherocompose.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(){
    Scaffold { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){
            HeroSearch()
            HeroList()
        }

    }
}

@Composable
fun HeroList() {
    TODO("Not yet implemented")
}

@Composable
fun HeroSearch() {
    TODO("Not yet implemented")
}
