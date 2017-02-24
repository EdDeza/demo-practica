package app.edwin.com.reportapetrabajador.presentation.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import app.edwin.com.reportapetrabajador.R;
import app.edwin.com.reportapetrabajador.data.entities.ReporteGrupal;
import app.edwin.com.reportapetrabajador.presentation.activities.MapsActivity;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by linuxdesarrollo01 on 20/02/17.
 */

public class ReportesAdapter extends RecyclerView.Adapter<ReportesAdapter.ReporteGrupalViewHolder> {
    Context context;
    ArrayList<ReporteGrupal> reportes;
    Activity activity;
    @BindView(R.id.direction)
    TextView direction;
    @BindView(R.id.tvdate)
    TextView tvdate;
    @BindView(R.id.tvtotal)
    TextView tvtotal;
    @BindView(R.id.cardview_rs)
    CardView cardviewRs;
    @BindView(R.id.btn_estado)
    Button btnEstado;
    @BindView(R.id.btn_mapa)
    Button btnMapa;

    public ReportesAdapter(ArrayList<ReporteGrupal> reportes, Activity activity) {
        this.reportes = reportes;
        this.activity = activity;
    }


    public static class ReporteGrupalViewHolder extends RecyclerView.ViewHolder {
        //Esta clase es la que interacciona con el layout
        private TextView tvdirection;
        private TextView tvdate;
        private TextView tvtotal;
        private Button btnEstado;
        private Button btn_mapa;
        private Button cambio_estado;

//        private ImageView imgReporte;

        public ReporteGrupalViewHolder(final View itemView) {
            super(itemView);
            tvdirection = (TextView) itemView.findViewById(R.id.direction);
            tvdate = (TextView) itemView.findViewById(R.id.tvdate);
            tvtotal = (TextView) itemView.findViewById(R.id.tvtotal);
            btn_mapa = (Button) itemView.findViewById(R.id.btn_mapa);
            btnEstado = (Button) itemView.findViewById(R.id.btn_estado);
            cambio_estado = (Button) itemView.findViewById(R.id.cambio_estado);


        }
    }


    public ReporteGrupalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_reporte, parent, false);
        //Esta linea de codigo asocia el layour cardview_contacto con el ReportesActivity

        return new ReporteGrupalViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ReporteGrupalViewHolder reporteViewHolder, int position) {
        //Aca pasamos la lista de reportes
        final ReporteGrupal reporte = reportes.get(position);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        reporteViewHolder.tvdate.setText(sdf.format(reporte.reportegrupal_fechahora));

        reporteViewHolder.tvtotal.setText(reporte.reportegrupal_contador + " reportes");

        reporteViewHolder.btn_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra("latitud", reporte.reportegrupal_latitud);
                intent.putExtra("longitud", reporte.reportegrupal_longitud);
                view.getContext().startActivity(intent);
            }
        });

        reporteViewHolder.btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(activity, SweetAlertDialog.NORMAL_TYPE)
                        .setTitleText("¡Atención!")
                        .setContentText("¿Desea cambiar el estado del reporte?")
                        .setConfirmText("Cambiar Estado")
                        .setCancelText("Cancelar")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.cancel();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.cancel();
                                reporteViewHolder.cambio_estado.setBackgroundResource(R.color.colorGreen);
                                reporteViewHolder.btnEstado.setText("ATENDIDO");
                                //Enviar el nuevo estado por POST
                            }
                        })
                        .show();

            }
        });

    }


    @Override
    public int getItemCount() {
        //Cantidad de elementos que contiene la cardview
        return reportes.size();
    }
}
