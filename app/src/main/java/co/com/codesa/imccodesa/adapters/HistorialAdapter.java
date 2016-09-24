package co.com.codesa.imccodesa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.model.Persona;

/**
 * Created by CODESA on 24/09/2016.
 */

public class HistorialAdapter extends BaseAdapter {

    private ArrayList<Persona> dataSource;
    private Context context;


    public HistorialAdapter(ArrayList<Persona> dataSource, Context context) {
        this.dataSource = dataSource;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view, null);
/*        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblAltura = (TextView) convertView.findViewById(R.id.lblAltura);
        TextView lblPeso = (TextView) convertView.findViewById(R.id.lblPeso);
        TextView lblImc = (TextView) convertView.findViewById(R.id.lblImc);


        Persona persona = (Persona) getItem(position);
        lblNombre.setText(persona.getNombre());
        lblAltura.setText(persona.getAltura() + "");
        lblPeso.setText(persona.getPeso() + "");
        lblImc.setText(persona.getImc() + "");
*/
        Persona persona = (Persona) getItem(position);
        HistorialHolder historialHolder = new HistorialHolder(convertView, persona);

        return convertView;
    }


    static class HistorialHolder {

        @Bind(R.id.lblNombre)
        TextView lblNombre;
        @Bind(R.id.lblAltura)
        TextView lblAltura;
        @Bind(R.id.lblPeso)
        TextView lblPeso;
        @Bind(R.id.lblImc)
        TextView lblImc;


        public HistorialHolder(View view, Persona persona) {

            ButterKnife.bind(this, view);

            lblNombre.setText(persona.getNombre());
            lblAltura.setText(persona.getAltura() + "");
            lblPeso.setText(persona.getPeso() + "");
            lblImc.setText(persona.getImc() + "");
        }
    }
}