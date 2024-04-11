package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.model.remote.HeroService

class HeroServiceFactory private constructor(){
    companion object{
        /*sin gleton, unica instancia de retrofit e igual aqui*/
        private var heroService: HeroService? = null

        fun getHeroService(): HeroService{
            if(heroService == null){
                heroService = RetrofitFactory.getRetrofit().create(HeroService::class.java) //reflection
            }
            return heroService as HeroService
        }

    }
}

/*
* Factory
* Singleton: Unica instancia, no puedes crear mas
*
*
* */