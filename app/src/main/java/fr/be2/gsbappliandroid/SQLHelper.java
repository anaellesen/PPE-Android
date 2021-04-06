package fr.be2.gsbappliandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper { //declaration des proprietes
    private static final String DB_NAME = "GSB.db";
    private static final String TABLE_NAME = "frais";
    public static final String ID = "id";
    public static final String TYPEFRAIT = "typefrait";
    public static final String LIBELLE = "libelle";
    public static final String QUANTITE = "quantite";
    public static final String DATE = "date";
    public static final String MONTANT = "montant";
    public static final String DATEACTU = "dateactu";

    private static final String TAG = "CountriesDbAdapter";
    private SQLiteDatabase db;

    // private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE +" ("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT" + ")";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + LIBELLE + " TEXT," + MONTANT + " TEXT," + TYPEFRAIT + " TEXT," + QUANTITE + " TEXT," + DATE + " TEXT," + DATEACTU + " DEFAULT CURRENT_TIMESTAMP) ";


    public SQLHelper(Context context) {

        super(context, DB_NAME, null, 1); //permet d'acceder au membre de la classe mere

    }

    //constructeur de la classe
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);   //METHODE qui vient desqlite et qui excute une requete sql

    }

    //destructeur de la classe
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {  // on detruit la table si elle existe deja puis on la recrée
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //methode qui retourne un resultat de type booleen
//insertData insert ds la bdd les données type et quantite renseignees par l'utilisateur
    public boolean insertData(String TYPEFRAIT1, Integer QUANTITE1, String LIBELLE1, double Montant1, String date1) {
//on cree une variable de type sqllitedatabasepr pouvoir y acceder
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPEFRAIT, TYPEFRAIT1);
        contentValues.put(QUANTITE, QUANTITE1);
        contentValues.put(LIBELLE, LIBELLE1);
        contentValues.put(String.valueOf(MONTANT), Montant1);
        contentValues.put(DATE, date1);

//insert sert a inserer des donnees, elle insere ds notre table contentValue les ontenus des variables que l'utilisateur renseigne
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;


    }


    public Cursor viewData() {
        db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor pointeur = db.rawQuery(query, null);
        return pointeur;
    }

    public boolean deleteData(Integer ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "ID=" + ID, null);
        return result != -1;
    }

    public SQLHelper open() throws SQLException {
        // mDbHelper = new SQLHelper(mCtx);
        db = this.getWritableDatabase();
        return this;
    }

    public Cursor fetchAllFrais() {

        Cursor mCursor = db.query(TABLE_NAME, new String[]{"rowid _id", ID,
                        LIBELLE, MONTANT, DATEACTU, DATE, QUANTITE},
                null, null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
