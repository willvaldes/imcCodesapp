package co.com.codesa.imccodesa.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.com.codesa.imccodesa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorialFragment extends Fragment {


    public HistorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_historial, container, false);
    }

}
