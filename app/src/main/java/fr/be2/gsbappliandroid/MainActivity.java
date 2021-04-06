package fr.be2.gsbappliandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fr.be2.GSBNote.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void unclique(View view) {
        if (view.getId() == R.id.btnfraisforfait) {
            Intent intent = new Intent(getApplicationContext(), FraisForfait.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnfraishorsforfait) {
            Intent intent = new Intent(getApplicationContext(), FraisHorsForfait.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnenvoi) {
            Intent intent = new Intent(getApplicationContext(), EnvoiDesDonneesVers.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnparametres) {
            Intent intent = new Intent(getApplicationContext(), Parametres.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnsynthese) {
            Intent intent = new Intent(getApplicationContext(), SyntheseDuMois.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnsynthese) {
            Intent intent = new Intent(getApplicationContext(), SyntheseDuMois.class);
            startActivity(intent);

        }

    }

    public void afficherMessage(String titre, String message) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setCancelable(true);
        Builder.setTitle(titre);
        Builder.setMessage(message);
        Builder.show();
    }

}
/*    public void FraisForfait(View view){
    //    Intent intent = new Intent(getApplicationContext(),FraisForfait.class);
        startActivity(intent);
    }

    public void FraisHorsForfait(View view){
        Intent intent = new Intent(getApplicationContext(),FraisHorsForfait.class);
        startActivity(intent);
    }

    public void EnvoiDesDonneesVers(View view){
        Intent intent = new Intent(getApplicationContext(),EnvoiDesDonneesVers.class);
        startActivity(intent);
    }

    public void Parametres(View view){
        Intent intent = new Intent(getApplicationContext(),Parametres.class);
        startActivity(intent);
    }

    public void SyntheseDuMois(View view){
        Intent intent = new Intent(getApplicationContext(),SyntheseDuMois.class);
        startActivity(intent);
    }
}*/


