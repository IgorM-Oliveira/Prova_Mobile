package br.unigran.prova.banco;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.prova.entidades.Consumo;

public class ConsumoDB {
    private DBHelper db;
    private SQLiteDatabase conexao;

    public ConsumoDB(DBHelper db) {
        this.db = db;
    }

    public void inserir(Consumo consumo) {
        conexao = db.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("quiloAtual", consumo.getQuiloAtual());
        valores.put("quantAbast", consumo.getQuantAbast());
        valores.put("dia", consumo.getDia());
        valores.put("valor", consumo.getValor());

        conexao.insertOrThrow("consumo", null, valores);

        conexao.close();
    }

    public void remover(Integer id) {
        conexao = db.getWritableDatabase();

        conexao.delete("consumo", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List listaConsumo) {
        listaConsumo.clear();
        conexao = db.getReadableDatabase();

        String colunas[] = {"id", "quiloAtual", "quantAbast", "dia", "valor"};

        Cursor query = conexao.query("listaConsumo", colunas, null, null, null, null, null);

        while (query.moveToNext()) {
            Consumo consumo = new Consumo();

            consumo.setId(Integer.parseInt(query.getString(0)));
            consumo.setQuiloAtual(query.getString(1));
            consumo.setQuantAbast(query.getString(2));
            consumo.setDia(query.getString(3));
            consumo.setValor(query.getString(4));

            listaConsumo.add(consumo);
        }

        conexao.close();
    }
}
