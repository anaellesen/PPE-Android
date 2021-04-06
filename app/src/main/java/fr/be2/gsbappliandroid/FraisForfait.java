package fr.be2.gsbappliandroid;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;

import fr.be2.GSBNote.R;

public class FraisForfait extends MainActivity implements View.OnClickListener {
    SQLHelper bd;
    EditText txtQte1;
    TextView date1;
    Spinner listeForfait1;
    Button btnAjouter1;
    Double tabMontant[] = new Double[]{0.0, 110.00, 0.62, 80.00, 25.00};
    DatePickerDialog picker;
    Calendar calendrier = Calendar.getInstance();
    int aa = calendrier.get(Calendar.YEAR);
    int mm = calendrier.get(Calendar.MONTH);
    int jj = calendrier.get(Calendar.DAY_OF_MONTH);

    //String tabType []= new String[]{"Forfait km" ,"forfait etape","Nuite hotel","Repas Restaurant"};
    double tarif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frais_forfait);
        init2();
        bd = new SQLHelper(this);
    }

    public void init2() {
        txtQte1 = findViewById(R.id.txtQte);
        listeForfait1 = findViewById(R.id.listeForfait);
        btnAjouter1 = findViewById(R.id.btnAjouter);
        date1 = findViewById(R.id.date);


    }

    public void ShowCal(View v) {
        picker = new DatePickerDialog(FraisForfait.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date1.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, aa, mm, jj);
        picker.show();
    }

    public void saveData(View v) {
        switch (v.getId()) {
            case R.id.btnAjouter:
                if (txtQte1.getText().toString().trim().length() == 0 || listeForfait1.getSelectedItem().toString().length() == 0 || date1.getText().toString().length() == 0) { // si rien dans txtQTE

                    afficherMessage("ERREUR", "aucune valeur saisie");
                    return;

                }

                //txtQte.getText() ;
                //listeForfait .getSelectedItemId() ;
                else {
                    Integer quantite = Integer.parseInt(String.valueOf(txtQte1.getText()));
                    String TypeF = listeForfait1.getSelectedItem().toString();
                    String DateF = date1.getText().toString();
                    int position = listeForfait1.getSelectedItemPosition();

                    tarif = quantite * tabMontant[position];
                    if (bd.insertData(TypeF, quantite, TypeF, tarif, DateF)) {
                        afficherMessage("succes", "valeur ajoutée");

                    }

                }
                break;
            case R.id.btnModifier:
                break;
            case R.id.btnSuprimer:
                break;

            case R.id.btnRetour:

                finish();
                break;
        }


    }

    @Override
    public void onClick(View view) {

    }

}









