package com.transmontanomobile.transmontanomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.transmontanomobile.transmontanomobile.model.Endereco;
import com.transmontanomobile.transmontanomobile.services.IRetrofitEndereco;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class ExibeCentrosMedicosActivity extends AppCompatActivity {

    ProgressDialog dialog;
    int imgFoto;
    private TextView txtRespCodigo;
    private TextView txtRespLocalidade;
    private TextView txtRespEndereco;
    private TextView txtRespAtendimento;
    private ImageView imgRespLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_centros_medicos);
        this.txtRespCodigo = findViewById(R.id.txtRespCodigo);
        this.txtRespLocalidade = findViewById(R.id.txtRespLocalidade);
        this.txtRespEndereco = findViewById(R.id.txtRespEndereco);
        this.txtRespAtendimento = findViewById(R.id.txtRespAtendimento);
        this.imgRespLocal = findViewById(R.id.imgRespLocal);

        Intent it = getIntent();
        final int id = Integer.parseInt(it.getStringExtra("ID"));
        Log.d("EXIBINDOLOCAL", "Id recebido = " + id);

        IRetrofitEndereco retrofitEndereco = IRetrofitEndereco.retrofit.create(IRetrofitEndereco.class);
        dialog = new ProgressDialog(ExibeCentrosMedicosActivity.this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(false);
        dialog.show();
        Call<List<Endereco>> chamada = retrofitEndereco.getEndereco();

        chamada.enqueue(new Callback<List<Endereco>>() {
            @Override
            public void onResponse(Call<List<Endereco>> call, Response<List<Endereco>> response) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    List<Endereco> lista = response.body();
                    Log.d("CHAMADAAPI", lista.toString());
                    Log.d("CHAMADAAPI", "Chamada bem sucedida!");
                    for (Endereco endereco : lista) {
                        if (Integer.parseInt(endereco.getCodigo()) == id) {
                            ExibeCentrosMedicosActivity.this.txtRespCodigo.setText(endereco.getCodigo());
                            ExibeCentrosMedicosActivity.this.txtRespLocalidade.setText(endereco.getLocalidade());
                            ExibeCentrosMedicosActivity.this.txtRespEndereco.setText(endereco.getEndereco());
                            ExibeCentrosMedicosActivity.this.txtRespAtendimento.setText(endereco.getHoraInicioAtendimento() + " às " + endereco.getHoraFinalAtendimento());
                            if (endereco.getBairro() == "Santana") {
                                imgFoto = R.drawable.santana;
                            } else if (endereco.getBairro() == "Bela Vista") {
                                imgFoto = R.drawable.belavista;
                            } else if (endereco.getBairro() == "Tatupé") {
                                imgFoto = R.drawable.tatuape;
                            } else if (endereco.getBairro() == "Campo Belo") {
                                imgFoto = R.drawable.campobelo;
                            } else if (endereco.getBairro() == "Praia Grande") {
                                imgFoto = R.drawable.praiagrande;
                            } else if (endereco.getBairro() == "São Vicente") {
                                imgFoto = R.drawable.saovicente;
                            } else if (endereco.getBairro() == "Sede") {
                                imgFoto = R.drawable.sede;
                            } else if (endereco.getBairro() == "SBC") {
                                imgFoto = R.drawable.scb;
                            } else if (endereco.getBairro() == "Santos") {
                                imgFoto = R.drawable.santos;
                            } else {
                                imgFoto = R.drawable.santos;
                            }
                            ExibeCentrosMedicosActivity.this.imgRespLocal.setImageResource(imgFoto);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Endereco>> call, Throwable t) {
                Log.d("CHAMADAAPI", "Chamada mal sucedida");
                Log.d("CHAMADAAPI", t.toString());
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    Toast toast = Toast.makeText(ExibeCentrosMedicosActivity.this, "Erro na rquisição. Por favor, tente novamente mais tarde", LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}
