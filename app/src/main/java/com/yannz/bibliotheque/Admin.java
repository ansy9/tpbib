package com.yannz.bibliotheque;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {

    DataBase db = null;
    EditText auteur;
    EditText titre;
    EditText motCle;
    EditText resume;

    EditText supprimer;
    String rech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        db = new DataBase(this);
        auteur = (EditText)findViewById(R.id.editText_auteur) ;
        titre = (EditText)findViewById(R.id.editText_titre);
        motCle = (EditText)findViewById(R.id.editText_motCle);
        resume = (EditText)findViewById(R.id.editText_resume);

        supprimer =(EditText)findViewById(R.id.editText_supprimerLivre);
    }

    public void ajouterLivre(View view)
    {
        db.InsererLivre(auteur.getText().toString(),titre.getText().toString(), motCle.getText().toString(),resume.getText().toString());
        auteur.setText("");
        titre.setText("");
        motCle.setText("");
        resume.setText("");

        Toast.makeText(Admin.this, "Livre ajouté avec succés !", Toast.LENGTH_SHORT).show();
    }

    public void chercherLivre(View view)
    {



        Intent recherche = new Intent(this, RechercheLivre.class) ;

        startActivity(recherche);

    }

    public void supprimerLivre(View view)
    {
        if(supprimer.getText().toString().equals(""))
        {
            Toast.makeText(Admin.this, "Entrez letitre du livre svp !", Toast.LENGTH_SHORT).show();
        }
        else if(db.existeTitre(supprimer.getText().toString())== -1)
        {
            Toast.makeText(Admin.this, "Livre inexistant !", Toast.LENGTH_SHORT).show();
        }
        else
        {
            db.delete(supprimer.getText().toString());
            Toast.makeText(Admin.this, "Livre supprimé avec succés !", Toast.LENGTH_SHORT).show();
        }

    }

    public void afficherLivres(View view)
    {
        Intent afficher = new Intent(this, AffichageLivre.class) ;
        startActivity(afficher);


    }

}
