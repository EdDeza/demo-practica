package app.edwin.com.reportapetrabajador.presentation.contracts;

import java.util.ArrayList;

import app.edwin.com.reportapetrabajador.core.BasePresenter;
import app.edwin.com.reportapetrabajador.core.BaseView;
import app.edwin.com.reportapetrabajador.data.entities.ReporteGrupal;

/**
 * Created by Desarrollo3 on 21/02/2017.
 */

public interface VerReportesContract {
    interface View extends BaseView<Presenter> {
        void mostrarLista(ArrayList<ReporteGrupal> reporteGrupal);
        void verReporteDenegado(String error);
    }
    interface Presenter extends BasePresenter {

    }
}
