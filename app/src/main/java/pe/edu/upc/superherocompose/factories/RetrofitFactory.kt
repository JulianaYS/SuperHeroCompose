package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.network.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory private constructor(){/*clase q no se puede instanciar*/
    companion object{/*como static*/
        private var retrofit : Retrofit? = null

        fun getRetrofit(): Retrofit{
            if (retrofit == null){
                retrofit = Retrofit.Builder().baseUrl(ApiClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit as Retrofit
        }
    }
}

/*? q puede ser nulo*/