package co.com.codesa.imccodesa.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.fragments.AutenticacionFragment;

public class ImcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        SharedPreferences sp = getSharedPreferences("user_data", Context.MODE_PRIVATE);

        Boolean isSigned = sp.getBoolean("isSigned", false);
        if (isSigned) {
            Intent intent = new Intent(this, ListaIMCActivity.class);
            startActivity(intent);
        } else {
            AutenticacionFragment autenticacionFragment = new AutenticacionFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, autenticacionFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }


    }
}
