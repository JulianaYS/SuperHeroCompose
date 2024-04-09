package pe.edu.upc.superherocompose.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import pe.edu.upc.superherocompose.model.data.Hero

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

    val heroes= remember {
        mutableStateOf(emptyList<Hero>())
    }

    LazyColumn {
        items(heroes.value)
    }
}

@Composable
fun HeroSearch() {
    TODO("Not yet implemented")
}
