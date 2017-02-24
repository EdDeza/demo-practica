package app.edwin.com.reportapetrabajador.data.repositories.remote.request;

import app.edwin.com.reportapetrabajador.data.entities.Login;
import app.edwin.com.reportapetrabajador.data.entities.Trabajador;

import app.edwin.com.reportapetrabajador.data.entities.TrabajadorCredentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Desarrollo3 on 9/02/2017.
 */

public interface LoginRequest {

    //Enviar Login
    @POST("vertrabajador/login")
    Call<Trabajador> login(@Body Trabajador  trabajador);


}
