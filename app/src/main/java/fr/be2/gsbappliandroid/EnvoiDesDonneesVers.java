package fr.be2.gsbappliandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import fr.be2.GSBNote.R;

public class EnvoiDesDonneesVers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoi_des_donnees_vers);
    }

    public void clique_retour(View view) {
        finish();
    }

}
