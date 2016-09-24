package co.com.codesa.imccodesa.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.adapters.HistorialAdapter;
import co.com.codesa.imccodesa.model.Persona;

public class ListaIMCActivity extends AppCompatActivity {

    @Bind(R.id.lstHistorial)
    ListView lstHistorial;
    ArrayList<Persona> lstPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imc);

        ButterKnife.bind(this);


        lstPersonas = new ArrayList<>();
        lstPersonas.add(new Persona("a",new Double("111"),new Double("111"),new Double("111")));
        lstPersonas.add(new Persona("b",new Double("111"),new Double("111"),new Double("111")));
        lstPersonas.add(new Persona("c",new Double("111"),new Double("111"),new Double("111")));
        lstPersonas.add(new Persona("d",new Double("111"),new Double("111"),new Double("111")));
        lstPersonas.add(new Persona("e",new Double("111"),new Double("111"),new Double("111")));
        lstPersonas.add(new Persona("f",new Double("111"),new Double("111"),new Double("111")));
        HistorialAdapter adapter = new HistorialAdapter(lstPersonas,this);
        lstHistorial.setAdapter(adapter);
    }
}
