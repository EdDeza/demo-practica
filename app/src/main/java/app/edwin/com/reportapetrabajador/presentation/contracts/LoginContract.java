package app.edwin.com.reportapetrabajador.presentation.contracts;

import app.edwin.com.reportapetrabajador.core.BasePresenter;
import app.edwin.com.reportapetrabajador.core.BaseView;

/**
 * Created by linuxdesarrollo01 on 20/02/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void loginSuccessfully();
        void loginDenied(String response);
    }
    interface Presenter extends BasePresenter {
        void loginApi(String email, String password);

    }
}