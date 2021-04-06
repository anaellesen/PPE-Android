package fr.be2.gsbappliandroid;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import fr.be2.GSBNote.R;


public class FraisHorsForfait extends MainActivity implements View.OnClickListener {
    SQLHelper bd;
    EditText txtLibelle2;
    EditText txtMontant2;
    TextView txtDate2;
    Button btnAjouter2;
    DatePickerDialog picker;
    Calendar calendrier = Calendar.getInstance();
    int aa = calendrier.get(Calendar.YEAR);
    int mm = calendrier.get(Calendar.MONTH);
    int jj = calendrier.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frais_hors_forfait);
        init();
        bd = new SQLHelper(this);
    }

    public void init() {
        txtLibelle2 = findViewById(R.id.txtLibelle);
        txtMontant2 = findViewById(R.id.txtMontant);
        txtDate2 = findViewById(R.id.txtDate);
        btnAjouter2 = findViewById(R.id.btnAjouterFHF);

        // btnAjouter.setOnClickListener(this);
    }

    public void ShowCal(View v) {
        picker = new DatePickerDialog(FraisHorsForfait.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txtDate2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, aa, mm, jj);
        picker.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAjouterFHF:
                if (txtLibelle2.getText().length() == 0 || txtMontant2.getText().length() == 0 || txtDate2.getText().length() == 0) { // si rien dans txtQT
                    afficherMessage("ERREUR", "aucune valeur saisie");
                    return;
                }
                //txtQte.getText() ;
                //listeForfait .getSelectedItemId() ;
                else {
                    Integer montant = Integer.parseInt(String.valueOf(txtMontant2.getText()));
                    String libelle = txtLibelle2.getText().toString();
                    String DateF2 = txtDate2.getText().toString();
                    if (bd.insertData("Hors Forfait", 0, libelle, montant, DateF2)) ;
                    afficherMessage("succes", "valeur ajoutée");
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
}