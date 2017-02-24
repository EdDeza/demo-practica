package app.edwin.com.reportapetrabajador.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import app.edwin.com.reportapetrabajador.R;
import app.edwin.com.reportapetrabajador.core.BaseActivity;
import app.edwin.com.reportapetrabajador.presentation.fragments.VerReportesFragment;
import app.edwin.com.reportapetrabajador.presentation.presenters.VerReportesPresenter;
import app.edwin.com.reportapetrabajador.utils.ActivityUtils;

/**
 * Created by linuxdesarrollo01 on 20/02/17.
 */

public class ReportesActivity extends BaseActivity {


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("vista reportes creada");
        setContentView(R.layout.activity_reportes);
        VerReportesFragment fragment = (VerReportesFragment) getSupportFragmentManager().findFragmentById(R.id.body_reportes
        );
        if (fragment == null){
            fragment = VerReportesFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.body_reportes);
        }

        new VerReportesPresenter(fragment , getApplicationContext());

    }

    @Override
    protected void onDestroy() {
        System.out.println("Vista reportes, destruida");
        super.onDestroy();
    }
}
