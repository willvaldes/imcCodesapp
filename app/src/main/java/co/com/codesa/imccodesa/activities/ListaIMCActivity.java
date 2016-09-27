package co.com.codesa.imccodesa.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.adapters.HistorialAdapter;
import co.com.codesa.imccodesa.model.Persona;

public class ListaIMCActivity extends AppCompatActivity {

    @Bind(R.id.lstHistorial)
    GridView lstHistorial;
    ArrayList<Persona> lstPersonas;


    @Bind(R.id.userName)
    TextView userName;

    @Bind(R.id.userEmail)
    TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imc);

        ButterKnife.bind(this);



        SharedPreferences sp = getSharedPreferences("user_data", Context.MODE_PRIVATE);

        userName.setText(sp.getString("userName","N/A"));
        userEmail.setText(sp.getString("userEmail","N/A"));


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
