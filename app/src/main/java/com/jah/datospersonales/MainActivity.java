package com.jah.datospersonales;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtApellidos, txtMail, txtTelefono;
    ImageButton imgBtnArriba, imgBtnAbajo;
    Switch swLogs;
    ArrayList<String> logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtMail = findViewById(R.id.txtMail);
        txtTelefono = findViewById(R.id.txtTelefono);
        imgBtnAbajo = findViewById(R.id.imgBtnAbajo);
        imgBtnArriba = findViewById(R.id.imgBtnArriba);
        swLogs = findViewById(R.id.swLogs);
        logs = new ArrayList<String>();

        txtNombre.requestFocus();
        swLogs.setOnCheckedChangeListener((compoundButton, checkedId) -> {
            activarLogs(checkedId, logs);
        });


        imgBtnAbajo.setOnClickListener(view -> {
            moverFocoAbajo(logs);
        });
        imgBtnArriba.setOnClickListener(view -> {
            moverFocoArriba(logs);
        });

    }

    private void moverFocoArriba(ArrayList<String> logs) {
        if(txtTelefono.hasFocus()){
            txtMail.requestFocus();
            logs.add(txtTelefono.getText().toString());
        } else if (txtMail.hasFocus()) {
            txtApellidos.requestFocus();
            logs.add(txtMail.getText().toString());
        }else if(txtApellidos.hasFocus()){
            txtNombre.requestFocus();
            logs.add(txtApellidos.getText().toString());
        }
    }

    private void moverFocoAbajo(ArrayList<String> logs) {

        if(txtNombre.hasFocus()){
            txtApellidos.requestFocus();
            logs.add(txtNombre.getText().toString());
        }else if(txtApellidos.hasFocus()){
            txtMail.requestFocus();
            logs.add(txtApellidos.getText().toString());
        }else if(txtMail.hasFocus()){
            txtTelefono.requestFocus();
            logs.add(txtMail.getText().toString());
        }
    }

    private void activarLogs(Boolean checkedId, ArrayList<String> logs) {
        if(checkedId){
            logs.add("----------------------------");
            for(String log : logs){
                Log.i("DAM", log);
            }
            logs.clear();
        }
    }

}