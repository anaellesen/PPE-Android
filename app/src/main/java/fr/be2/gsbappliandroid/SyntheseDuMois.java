package fr.be2.gsbappliandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import fr.be2.GSBNote.R;

public class SyntheseDuMois extends AppCompatActivity {


    private SQLHelper bd;
    private SimpleCursorAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthese_du_mois);
        bd = new SQLHelper(this);
        bd.open();


        //Générer le ListView a partir de SQLite Database
        displayListView();

    }

    private void displayListView() {


        Cursor cursor = bd.fetchAllFrais();

        // Les colonnes que l’on veut lier
        String[] columns = new String[]{
                SQLHelper.ID,
                SQLHelper.LIBELLE,
                SQLHelper.MONTANT,
                SQLHelper.DATEACTU,
                SQLHelper.DATE,
                SQLHelper.QUANTITE
        };
        // Les éléments defnis dans le XML auxquels les données sont liées
        int[] to = new int[]{
                R.id.id,
                R.id.libelle,
                R.id.montant,
                R.id.datesaisie,
                R.id.datefrais,
                R.id.quantite,
        };
        //On créer l'adaptateur à l'aide du curseur pointant sur les données souhaitées  ainsi que les informations de mise en page
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.frais_info,
                cursor,
                columns,
                to,
                0);

        ListView listView1 = (ListView) findViewById(R.id.listeFF);
        // Attribuer l’adapter au ListView
        listView1.setAdapter(dataAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> listView1, View view,
                                    int position, long id) {
                long objid = view.getId();
                if (objid == R.id.delete) {
                    // On obtient le curseur, positionne sur la ligne correspondante dans le jeu de résultats
                    Cursor cursor = (Cursor) listView1.getItemAtPosition(position);

                    // On obtient la Capital du pays
                    String myid =
                            cursor.getString(cursor.getColumnIndexOrThrow("id"));
                    Toast.makeText(getApplicationContext(),
                            myid, Toast.LENGTH_SHORT).show();
                    Integer myid1 = Integer.parseInt(myid);
                    bd.deleteData(myid1);
                    displayListView();

                }
            }
        });


    }


    public void clique_retour(View view) {
        finish();
    }

}
