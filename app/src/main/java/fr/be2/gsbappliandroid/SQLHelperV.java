package fr.be2.gsbappliandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLHelperV extends SQLiteOpenHelper {

    //declaration des proprietes
    private static final String DB_NAME = "GSB.db";
    private static final String TABLE_NAME = "visiteur";
    private static final String ID = "ID";
    private static final String NOM = "NOM";
    private static final String PRENOM = "PRENOM";
    private static final String LOGIN = "LOGIN";
    private static final String MDP = "MDP";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + ID + "INTEGER PRIMARY KEY AUTOINCREMENT" + "," + NOM + "," + PRENOM + " ," + LOGIN + "," + MDP + " ) ";
    //"create table visiteur (id,nom,prenom,login,mdp)";


    public SQLHelperV(Context context) {

        super(context, DB_NAME, null, 1);

    }

    //constructeur de la classe
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);   //METHODE qui vient desqlite et qui excute une requete sql
        remplissageTable(sqLiteDatabase);
    }

    //destructeur de la classe
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {  // on detruit la table si elle existe deja puis on la recrée
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void remplissageTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME + " values(andre,david,dandre,oppg5 ),(seneor,anaelle,anas,sen16 ),(cohen,lea,colea,coh15 )");
    }

    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor pointeur = db.rawQuery(query, null);
        return pointeur;
    }

    public boolean deleteData(Integer ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "ID=" + ID, null);
        return result != -1;
    }

}
