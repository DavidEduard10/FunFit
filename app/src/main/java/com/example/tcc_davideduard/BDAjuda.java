package com.example.tcc_davideduard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDAjuda extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nome = "Login_Registro_BD_FunFit.db";

    public BDAjuda(@Nullable Context context) {
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE Utilizador(username TEXT PRIMARY KEY, password TEXT);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilizador;");
        onCreate(db);
    }

    public long CriarUtilizador(String usuario, String senha) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", usuario);
        cv.put("senha", senha);
        long resultado = db.insert("Utilizador", null, cv);
        return resultado;
    }

    public String ValidarLogin(String usuario, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Utilizador WHERE usuario=? AND senha=?", new String[]{usuario, senha});
        if (c.getCount() > 0) {
            return "OK";
        }
        return "ERRO";
    }
}
