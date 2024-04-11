package pe.edu.upc.superherocompose.model.remote

import pe.edu.upc.superherocompose.model.data.HeroWrapper
import retrofit2.Call
import retrofit2.http.GET

interface HeroService {/*solo contiene metodos, pero no implemtaciones, solo declaraciones*/
    @GET("10157703717092094/search/batman")
    fun getHeroes(): Call<HeroWrapper>
}

/*
Network
constantes q se necesitan url base

implementar interfaz

Patron:
Repository: recibe consulta de externo, mantine control de todos los estados q se utiliza (view model)

*/