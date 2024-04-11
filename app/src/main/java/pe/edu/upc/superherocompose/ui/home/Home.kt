package pe.edu.upc.superherocompose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.repositories.HeroRepository

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

    HeroRepository().getHeroes {
        heroes.value = it
    }

    LazyColumn {
        items(heroes.value){hero->
            HeroItem(hero)
        }
    }
}
@Composable
fun HeroItem(hero: Hero){
    Card (modifier = Modifier.fillMaxWidth().padding(8.dp)){
        Row {
            HeroImage(hero.image.url)
            Column (modifier = Modifier.padding(6.dp).weight(8.5f)){
                Text(text=hero.name, color = Color.Red)
                Text(text = hero.biography.fullName)
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1.5f)) {
                Icon(Icons.Filled.Favorite, "Favorite")

            }
        }
    }

}
@Composable
fun HeroImage(url: String){
    GlideImage(imageModel = { url }, modifier = Modifier.size(92.dp))

}
@Composable
fun HeroSearch() {
}


// git config user.name "JulianaYS"
// git config user.email u20201b782@upc.edu.pe

