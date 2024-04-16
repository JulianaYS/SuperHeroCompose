package pe.edu.upc.superherocompose.ui.herodetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.model.data.PowerState
import pe.edu.upc.superherocompose.repositories.HeroRepository
import pe.edu.upc.superherocompose.ui.heroessearch.HeroImage
import pe.edu.upc.superherocompose.ui.theme.SuperHeroComposeTheme


@Composable
fun HeroDetails(id: String) {

    val hero= remember {
        mutableStateOf<Hero?>(null)
    }
    HeroRepository().getHeroById(id){
        hero.value=it
    }
    hero.value?.let {
        Scaffold { paddingValues ->
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally){
                HeroImage(url = it.image.url, 256.dp)
                HeroHeader(it.name)
                HeroPowerStats(it.powerStats)
                HeroBiography(it.biography)
            }

        }
    }
}

@Composable
fun HeroStat(stat: String, powerStat: String){
    Row (verticalAlignment = Alignment.CenterVertically){
        Text(text = )

    }
}
@Composable
fun HeroBiography(biography: Biography) {
    Card {
        Column (modifier = Modifier.fillMaxSize()){
            Text(text = "Biography", style = MaterialTheme.typography.titleMedium)
            Text(text = "Full name: ${biography.fullName}")
            Text(text = "Place of birth: ${biography.placeOfBirth}")
            Text(text = "Publisher: ${biography.publisher}")
        }
    }

}

@Composable
fun HeroPowerStats(powerStats: PowerState) {
    TODO("Not yet implemented")
}

@Composable
fun HeroHeader(name: String){
    Text(text = name, style=MaterialTheme.typography.headlineMedium)
}

/*
@Preview
@Composable
fun HeroDetailsPreview(){
    SuperHeroComposeTheme {
        HeroDetails(id="70")
    }
}*/