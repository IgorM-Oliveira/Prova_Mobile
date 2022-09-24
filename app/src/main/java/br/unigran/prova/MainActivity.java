package br.unigran.prova;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.unigran.prova.banco.ConsumoDB;
import br.unigran.prova.banco.DBHelper;
import br.unigran.prova.entidades.Consumo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText campoQuantAtual;
    EditText campoQuilAtual;
    EditText campoDia;
    EditText campoValor;
    TextView campoCalculo;

    Button botaoSalvar;

    ListView listagemDados;
    List<Consumo> listaConsumo;
    ArrayAdapter adapter;

    ConsumoDB consumoDB;
    Consumo consumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(MainActivity.this);
        consumoDB = new ConsumoDB(db);

        campoQuantAtual = findViewById(R.id.quantAbast);
        campoQuilAtual = findViewById(R.id.quiloAtual);
        campoDia = findViewById(R.id.dia);
        campoValor = findViewById(R.id.valor);
        campoCalculo = findViewById(R.id.calculo);
        botaoSalvar = findViewById(R.id.salvar);
        listagemDados = findViewById(R.id.linearLayout);

        listaConsumo = new ArrayList();
        adapter = new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaConsumo);

        listagemDados.setAdapter(adapter);
        consumoDB.listar(listaConsumo);

        campoQuantAtual.requestFocus();

        campoCalculo.setText(String.format("%.2f", calcularConsumo()));
        acaoComponentes();
    }

    @Override
    public void onBackPressed() {
        consumo = null;
        campoQuantAtual.setText("");
        campoQuantAtual.requestFocus();
        campoQuilAtual.setText("");
        campoDia.setText("");
        campoValor.setText("");

        Toast.makeText(MainActivity.this, "Operação cancelada com Sucesso!", Toast.LENGTH_LONG).show();
    }

    private void acaoComponentes() {
        listagemDados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(view.getContext())
                        .setMessage("Selecione uma Opção:")
                        .setNegativeButton("Remover", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int j) {
                                new AlertDialog.Builder(view.getContext())
                                        .setMessage("Deseja realmente remover?")
                                        .setPositiveButton("Remover", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int k) {
                                                consumoDB.remover(listaConsumo.get(i).getId());

                                                consumoDB.listar(listaConsumo);
                                                adapter.notifyDataSetChanged();

                                                Toast.makeText(MainActivity.this, "Removido com Sucesso!", Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .setNegativeButton("Cancelar", null)
                                        .create().show();
                            }
                        })
                        .create().show();
                return (false);
            }
        });

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (campoQuantAtual.getText().toString().isEmpty() || campoQuilAtual.getText().toString().isEmpty() || campoDia.getText().toString().isEmpty() || campoValor.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Dados Inválidos!", Toast.LENGTH_SHORT).show();
                } else {
                    consumo.setQuantAbast(campoQuantAtual.getText().toString());
                    consumo.setQuiloAtual(campoQuilAtual.getText().toString());
                    consumo.setDia(campoDia.getText().toString());
                    consumo.setValor(campoValor.getText().toString());

                    consumoDB.inserir(consumo);

                    Toast.makeText(MainActivity.this, "Salvo com Sucesso!", Toast.LENGTH_LONG).show();

                    consumoDB.listar(listaConsumo);
                    adapter.notifyDataSetChanged();

                    consumo = null;
                    campoQuantAtual.setText("");
                    campoQuantAtual.requestFocus();
                    campoQuilAtual.setText("");
                    campoDia.setText("");
                    campoValor.setText("");
                }
            }
        });
    }

    private float calcularConsumo() {
        Float consumo;

        consumo = 0f;

        return (consumo);
    }
}