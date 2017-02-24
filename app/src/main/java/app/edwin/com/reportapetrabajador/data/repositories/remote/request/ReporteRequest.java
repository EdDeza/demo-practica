package app.edwin.com.reportapetrabajador.data.repositories.remote.request;


import app.edwin.com.reportapetrabajador.data.entities.Reporte;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Desarrollo3 on 9/02/2017.
 */

public interface ReporteRequest {
    @GET("reportegrupal/reportegrupalporid/{reportegrupal_id}")
    Call<Reporte> contributors(
            @Path("reportegrupal_id") int reportegrupal_id
    );


}
