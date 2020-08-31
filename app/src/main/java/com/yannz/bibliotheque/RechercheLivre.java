package com.yannz.bibliotheque;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RechercheLivre extends AppCompatActivity {
    DataBase db = null;
    EditText recherche;
    ListView ls;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_livre);
        db = new DataBase(this);
        recherche =(EditText)findViewById(R.id.editText_chercherLivre);
        ls = (ListView)findViewById(R.id.listView);


    }

    public void chercher(View view)
    {
        int deb=0;
        int res=db.existe(recherche.getText().toString());
        deb=1;
        if ( res == 1 ) {
            deb=2;
            ArrayList<String> list = db.getAllrecord2(recherche.getText().toString());
            deb=3;
            ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
            deb=4;

        }
        else  Toast.makeText(RechercheLivre.this, "Livre inexistant", Toast.LENGTH_SHORT).show();
    }

}
