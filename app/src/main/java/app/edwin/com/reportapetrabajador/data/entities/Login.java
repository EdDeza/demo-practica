package app.edwin.com.reportapetrabajador.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Desarrollo3 on 24/02/2017.
 */

public class Login {

    public String estado;
    public ArrayList<Trabajador> datos;
    public String mensaje;

    public Login (String estado, ArrayList<Trabajador> datos, String mensaje) {
        this.estado = estado;
        this.datos = datos;
        this.mensaje = mensaje;
    }
}
