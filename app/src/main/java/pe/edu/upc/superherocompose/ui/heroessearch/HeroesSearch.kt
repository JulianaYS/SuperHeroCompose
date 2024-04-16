package pe.edu.upc.superherocompose.ui.heroessearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.repositories.HeroRepository

@Composable
fun HeroesSearch(){
    val heroes= remember {
        mutableStateOf(emptyList<Hero>())
    }
    Scaffold { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){
            HeroSearch(heroes)
            HeroList(heroes)
        }

    }
}

@Composable
fun HeroList(heroes: MutableState<List<Hero>>, selectHero: (String)->Unit) {

    LazyColumn {
        items(heroes.value){hero->
            HeroItem(hero, selectHero)
        }
    }
}
@Composable
fun HeroItem(hero: Hero, selectHero: (String)->Unit){
    val like= remember {
        mutableStateOf(false)
    }

    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        onClick = {
            selectHero()
        } ){
        Row {
            HeroImage(hero.image.url)
            Column (modifier = Modifier
                .padding(6.dp)
                .weight(8.5f)){
                Text(text=hero.name, color = Color.Red)
                Text(text = hero.biography.fullName)
            }
            IconButton(onClick = { like.value=!like.value }, modifier = Modifier.weight(1.5f)) {
                Icon(Icons.Filled.Favorite, "Favorite", tint = if (like.value) MaterialTheme.colorScheme.inversePrimary else Color.Black)

            }
        }
    }

}
@Composable
fun HeroImage(url: String, size: Dp){
    GlideImage(imageModel = { url }, modifier = Modifier.size(92.dp))

}
@Composable
fun HeroSearch(selectHero: (String)->Unit) {
    val search = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = search.value,
        onValueChange={search.value = it} ,
        placeholder = { Text(text = "Search hero")} ,
        leadingIcon = { Icon(Icons.Filled.Search, "Search" )},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            HeroRepository().getHeroes(search.value) {
                heroes.value = it
            }
            /*desde aqui llamar al repository*/
        }),
        modifier = Modifier.fillMaxWidth())
}


// git config user.name "JulianaYS"
// git config user.email u20201b782@upc.edu.pe

/*
* mapeat datos
* poner el acceso a internet*/

/*hacer q cambie el color del corazon al presionar*/