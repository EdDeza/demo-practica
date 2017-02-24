package app.edwin.com.reportapetrabajador.presentation.presenters;

import android.content.Context;
import android.os.Trace;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import app.edwin.com.reportapetrabajador.data.entities.Login;
import app.edwin.com.reportapetrabajador.data.entities.Trabajador;
import app.edwin.com.reportapetrabajador.data.entities.TrabajadorCredentials;
import app.edwin.com.reportapetrabajador.data.repositories.local.SessionManager;
import app.edwin.com.reportapetrabajador.data.repositories.remote.Model.ApiError;
import app.edwin.com.reportapetrabajador.data.repositories.remote.ServiceGeneratorSimple;
import app.edwin.com.reportapetrabajador.data.repositories.remote.request.LoginRequest;
import app.edwin.com.reportapetrabajador.presentation.contracts.LoginContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.*;

/**
 * Created by linuxdesarrollo01 on 20/02/17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private SessionManager sessionManager;

    public LoginPresenter(LoginContract.View mView, Context context) {
        this.mView = mView;
        this.sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }


    @Override
    public void start() {

    }

    @Override
    public void loginApi(String email, String password) {
        mView.setLoadingIndicator(true);
        LoginRequest loginRequest = ServiceGeneratorSimple.createService(LoginRequest.class);
        final Trabajador trabajador = new Trabajador(email, password);
        Call<Trabajador> call = loginRequest.login(trabajador);
        call.enqueue(new Callback<Trabajador>() {
                         @Override
                         public void onResponse(Call<Trabajador> call, Response<Trabajador> response) {
                             // The network call was a success and we got a response
                             System.out.println(response.message());


                             if (!response.isSuccessful()) {
                                 String error = "Ha ocurrido un error. Contacte al administrador";
                                 if (response.errorBody()
                                         .contentType()
                                         .subtype()
                                         .equals("json")) {
                                     ApiError apiError = ApiError.fromResponseBody(response.errorBody());

                                     error = apiError.getMessage();
                                     Log.d("LoginActivity", apiError.getDeveloperMessage());
                                 } else {
                                     try {
                                         // Reportar causas de error no relacionado con la API
                                         Log.d("LoginActivity", response.errorBody().string());
                                     } catch (IOException e) {
                                         e.printStackTrace();
                                     }
                                 }
                                 System.out.println(error);
                                 return;
                             } else {

                                 // TODO: use the repository list and display it
                                 System.out.println(response.errorBody());
                                 System.out.println(response.message());
                                 System.out.println("ENVIADO");
                             }

                         }

                         @Override
                         public void onFailure(Call<Trabajador> call, Throwable t) {
                             // the network call was a failure
                             // TODO: handle error
                             System.out.println("NO ENVIADO");
                             System.out.println("error: " + t.toString());

                         }
                     }

        );
       /* mView.setLoadingIndicator(true);
        LoginRequest loginRequest = ServiceGeneratorSimple.createService(LoginRequest.class);
        Call<TrabajadorSerializable> call = loginRequest.login(email,password);
        call.enqueue(new Callback<TrabajadorSerializable>() {
            @Override
            public void onResponse(Call<TrabajadorSerializable> call, Response<TrabajadorSerializable> response) {
                if (!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.loginSuccessfully();
                    System.out.println(response);
                    System.out.println(call);
                }
                else {
                    mView.loginDenied("Correo incorrecto");
                    System.out.println(response);
                    System.out.println(call);
                }
            }

            @Override
            public void onFailure(Call<TrabajadorSerializable> call, Throwable t) {
                if (!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.loginDenied("No se pudo acceder al servidor en este momento");
            }
        });*/
    }

}