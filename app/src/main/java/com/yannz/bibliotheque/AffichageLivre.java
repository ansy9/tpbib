package com.yannz.bibliotheque;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AffichageLivre extends AppCompatActivity {
    DataBase db = null;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_livre);
        db = new DataBase(this);
        ls = (ListView)findViewById(R.id.listView);

        int n = db.compt();
        ArrayList<String> liste = db.getAllrecord();

        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, liste));

        Toast.makeText(AffichageLivre.this, "" + n, Toast.LENGTH_SHORT).show();

    }
}
