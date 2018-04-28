package br.com.supra.gestaoescolar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CadastroActivity extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="cadastro.db";
    public static final String TABLE_NAME="cadastroPessoa";
    public static final String COLUMN_N0ME="Nome";
    public static final String COLUMN_SOBRENAME="Sobrenome";
    public static final String COLUMN_SENHA="Senha";
    public static final String COLUMN_EMAIL="Email";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table cadastro( id integer primary key not null, " +
            "Nome text not null,Sobrenome text not null, Email text not null, Senha text not null );";

    public CadastroActivity(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void InsertData(CadastroMethods cadastroMethods) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from cadastroPessoa";
        Cursor cursor = db.rawQuery( query, null );
        int count = cursor.getCount();
        values.put(CadastroActivity.COLUMN_N0ME,cadastroMethods.getNome());
        values.put(CadastroActivity.COLUMN_EMAIL,cadastroMethods.getEmail());
        values.put(CadastroActivity.COLUMN_SENHA,cadastroMethods.getSenha());
        values.put(CadastroActivity.COLUMN_SOBRENAME,cadastroMethods.getSobrenome());
        db.insert(TABLE_NAME,null,values);
        db.close();

    }

    public String searchPass(String email){
        db = getReadableDatabase();
        String query = "select Email, Senha from "+ TABLE_NAME;
        Cursor cursor = db.rawQuery( query, null );
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString( 0 );
                b = cursor.getString( 1 );

                if(a.equals( email )){
                    b = cursor.getString( 1 );
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }



}
