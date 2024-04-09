package pe.edu.upc.superherocompose.model.data

data class HeroWrapper(
    val heroes: List<Hero>
)

data class Hero (
    val name : String,
    val biography: Biography,
    val image: Image
    )

data class Biography(
    val fullName: String
)

data class Image(
    val url:String
)
