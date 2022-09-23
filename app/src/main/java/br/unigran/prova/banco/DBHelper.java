package br.unigran.prova.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) { super(context, "Consumo", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String querySQL =
                "create table consumo(" +
                        "id integer primary key autoincrement," +
                        "quiloAtual varchar(10)," +
                        "quantAbast varchar(10)," +
                        "dia varchar(10)," +
                        "valor varchar(15))";

        sqLiteDatabase.execSQL(querySQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
