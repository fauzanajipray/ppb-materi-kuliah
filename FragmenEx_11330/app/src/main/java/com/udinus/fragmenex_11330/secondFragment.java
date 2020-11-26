package com.udinus.fragmenex_11330;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class secondFragment extends Fragment {
    View view;
    Button secondButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        secondButton = (Button) view.findViewById(R.id.secondButton);
        secondButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getActivity(),"Fragment Kedua", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
