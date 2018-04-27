package br.com.supra.gestaoescolar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CadastroActivity extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="cadastro.db";
    public static final String TABLE_NAME="cadastroPessoa";
    public static final String COL_1="ID";
    public static final String COL_2="Nome";
    public static final String COL_3="Sobrenome";
    public static final String COL_4="Senha";
    public static final String COL_5="Email";
    public static final String COL_6="Telefone";

    public CadastroActivity(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Nome TEXT,Sobrenome TEXT,Senha TEXT,Email TEXT,Telefone TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME); //Drop older table if exists
        onCreate(db);
    }
}
