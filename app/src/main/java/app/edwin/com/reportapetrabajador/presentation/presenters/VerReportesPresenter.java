package app.edwin.com.reportapetrabajador.presentation.presenters;


import android.content.Context;


import com.google.gson.Gson;

import app.edwin.com.reportapetrabajador.data.entities.Reporte;
import app.edwin.com.reportapetrabajador.data.entities.ReporteGrupal;
import app.edwin.com.reportapetrabajador.data.repositories.local.SessionManager;
import app.edwin.com.reportapetrabajador.data.repositories.remote.ServiceGeneratorSimple;
import app.edwin.com.reportapetrabajador.data.repositories.remote.request.ReporteRequest;
import app.edwin.com.reportapetrabajador.presentation.contracts.VerReportesContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Desarrollo3 on 15/02/2017.
 */

public class VerReportesPresenter implements VerReportesContract.Presenter {
    private VerReportesContract.View mView;
    Context context;
    SessionManager sessionManager;

    public VerReportesPresenter(VerReportesContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        this.mView.setPresenter(this);

        //sessionManager = new SessionManager(context);
    }


    @Override
    public void start() {
        mView.setLoadingIndicator(true);
        //String email = sessionManager.getEmail();
        ServiceGeneratorSimple serviceGeneratorSimple = new ServiceGeneratorSimple();
        Gson gsonDate = serviceGeneratorSimple.construyeGsonDeserializador();
        ReporteRequest reporteRequest = serviceGeneratorSimple.establecerConexionRestApi(gsonDate);

        Call<Reporte> call = reporteRequest.contributors(1001);
        call.enqueue(new Callback<Reporte>() {
            @Override
            public void onResponse(Call<Reporte> call, Response<Reporte> response) {
                if (!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    System.out.println(call+ "    ");
                    System.out.println(response);
                    mView.mostrarLista(response.body().datos);
                }else {
                    mView.verReporteDenegado("Hubo un error al mostrar la lista");
                }

            }

            @Override
            public void onFailure(Call<Reporte> call, Throwable t) {
                System.out.println("F A L L A ---> " + call);
                System.out.println(t);
                if (!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.verReporteDenegado("No se pudo acceder al servidor en este momento");
            }
        });
    }
}
