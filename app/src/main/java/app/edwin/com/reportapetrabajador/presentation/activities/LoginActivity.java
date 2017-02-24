package app.edwin.com.reportapetrabajador.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import app.edwin.com.reportapetrabajador.R;
import app.edwin.com.reportapetrabajador.core.BaseActivity;
import app.edwin.com.reportapetrabajador.presentation.fragments.LoginFragment;
import app.edwin.com.reportapetrabajador.presentation.presenters.LoginPresenter;
import app.edwin.com.reportapetrabajador.utils.ActivityUtils;

/**
 * Created by linuxdesarrollo01 on 20/02/17.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        LoginFragment fragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.body_login);
        if (fragment == null){
            fragment = LoginFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.body_login);
        }

        new LoginPresenter(fragment , getApplicationContext());

    }
}
