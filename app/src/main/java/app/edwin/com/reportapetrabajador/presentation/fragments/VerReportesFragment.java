package app.edwin.com.reportapetrabajador.presentation.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import app.edwin.com.reportapetrabajador.R;
import app.edwin.com.reportapetrabajador.core.BaseFragment;
import app.edwin.com.reportapetrabajador.data.entities.ReporteGrupal;
import app.edwin.com.reportapetrabajador.presentation.activities.MapsActivity;
import app.edwin.com.reportapetrabajador.presentation.adapters.ReportesAdapter;
import app.edwin.com.reportapetrabajador.presentation.contracts.VerReportesContract;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Desarrollo3 on 15/02/2017.
 */

public class VerReportesFragment extends BaseFragment implements VerReportesContract.View {

    ReportesAdapter reportesAdapter;
    LinearLayoutManager linearLayoutManager;
    VerReportesContract.Presenter presenter;
    @BindView(R.id.Reportes)
    RecyclerView Reportes;
    @BindView(R.id.btn_llevame)
    Button btnLlevame;


    public static VerReportesFragment newInstance() {
        return new VerReportesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recicleviewrs, container, false);
        ButterKnife.bind(this, v);
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Reportes.setLayoutManager(linearLayoutManager);
        presenter.start();

    }

    @Override
    public void mostrarLista(ArrayList<ReporteGrupal> reporteGrupal) {
        reportesAdapter = new ReportesAdapter(reporteGrupal, getActivity());
        Reportes.setAdapter(reportesAdapter);
    }

    @Override
    public void verReporteDenegado(String error) {

    }

    @Override
    public void setPresenter(VerReportesContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {

        } else {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.btn_llevame)
    public void onClick() {

        nextActivity(getActivity(), null , MapsActivity.class, false);
    }
}
