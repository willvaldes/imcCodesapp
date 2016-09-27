package co.com.codesa.imccodesa.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.activities.ListaIMCActivity;

public class AutenticacionFragment extends Fragment {

    private FirebaseAuth mAuth;
    private ProgressDialog progress;

    @Bind(R.id.txtLoginUsuario)
    EditText txtLoginUsuario;

    @Bind(R.id.txtLoginPassword)
    EditText txtLoginPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_autenticacion, null);
        ButterKnife.bind(this, view);

        mAuth = FirebaseAuth.getInstance();
        SharedPreferences sp = getContext().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isSigned", false);
        editor.commit();

        return view;
    }

    @OnClick(R.id.btnLoginIngresar)
    public void clikIngresar() {

        progress = ProgressDialog.show(getContext(), "Procesando", "Comprobando datos de ingreso...");

        String email = txtLoginUsuario.getText().toString();
        String password = txtLoginPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(RegistroFragment.class.getName(), "Resultado Log In : " + task.isSuccessful());

                        if (task.isSuccessful()) {
                            SharedPreferences sp = getContext().getSharedPreferences("user_data", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            FirebaseUser user = mAuth.getCurrentUser();
                            editor.putString("userEmail", user.getEmail());
                            editor.putString("userName", user.getDisplayName());
                            editor.commit();

                            Intent intent = new Intent(getContext(), ListaIMCActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        progress.dismiss();
                    }
                });

    }

    @OnClick(R.id.btnLoginCrearCuenta)
    public void clikCrearCuenta() {

        RegistroFragment registroFragment = new RegistroFragment();

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, registroFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
