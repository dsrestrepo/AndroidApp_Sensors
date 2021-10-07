package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static android.provider.Contacts.SettingsColumns.KEY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //defino la variable arreglo
        ArrayList<String> Meses;
        Meses = new ArrayList<String>();
        Meses.add("enero");
        Meses.add("febreo");
        Meses.add("marzo");
        Meses.add("abril");

        /*for (int i=0; i<4; i++){
            Datos.add( i+"" );


        }*/

        Meses = (ArrayList<String>) getIntent().getSerializableExtra(KEY);
    }


    public void siguiente (View view){
        Intent siguiente =new Intent(this,Main2Activity.class);
        startActivity(siguiente);
        //startActivityForResult(siguiente,Meses);
    }
}
