package app.edwin.com.reportapetrabajador.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Desarrollo3 on 24/02/2017.
 */

public class TrabajadorCredentials {
    @SerializedName("trabajador_correo")
    String email;
    @SerializedName("trabajador_contrasena")
    String password;

    public TrabajadorCredentials(String email, String password){
        this .email = email;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
