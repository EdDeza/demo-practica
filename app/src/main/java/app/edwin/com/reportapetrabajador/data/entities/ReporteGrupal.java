package app.edwin.com.reportapetrabajador.data.entities;

import java.util.Date;

/**
 * Created by linuxdesarrollo01 on 20/02/17.
 */

public class ReporteGrupal {
    public String reportegrupal_id;
    public String reportegrupal_estado;
    public String reportegrupal_contador;
    public String reportegrupal_latitud;
    public String reportegrupal_longitud;
    public Date reportegrupal_fechahora;

    public ReporteGrupal(String reportegrupal_id, String reportegrupal_estado, String reportegrupal_contador) {
        this.reportegrupal_id = reportegrupal_id;
        this.reportegrupal_estado = reportegrupal_estado;
        this.reportegrupal_contador = reportegrupal_contador;
    }




}
