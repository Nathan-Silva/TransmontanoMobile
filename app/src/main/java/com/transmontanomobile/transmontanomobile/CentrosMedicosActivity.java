package com.transmontanomobile.transmontanomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.transmontanomobile.transmontanomobile.adapters.Endereco;
import com.transmontanomobile.transmontanomobile.adapters.ListaEnderecoAdapter;
import com.transmontanomobile.transmontanomobile.services.IRetrofitEndereco;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CentrosMedicosActivity extends AppCompatActivity {

    ListView lvListaEndereco;
    ProgressDialog dialog;
    ArrayList<Endereco> enderecosAdapter = new ArrayList<>();
    int imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_medicos);
        this.lvListaEndereco = findViewById(R.id.lvListaEndereco);

        IRetrofitEndereco chamada = IRetrofitEndereco.retrofit.create(IRetrofitEndereco.class);
        dialog = new ProgressDialog(CentrosMedicosActivity.this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(false);
        dialog.show();
        Call<List<Endereco>> resposta = chamada.getEndereco();
        Log.d("CHAMADAAPI", String.valueOf(resposta));
        resposta.enqueue(new Callback<List<Endereco>>() {
            @Override
            public void onResponse(Call<List<Endereco>> call, Response<List<Endereco>> response) {
                if (dialog.isShowing()) {
                    dialog.dismiss();

                    List<Endereco> dto = response.body();
                    Log.d("CHAMADAAPI", dto.toString());
                    Log.d("CHAMADAAPI", "Chamada bem sucedida!");
                    for (Endereco local : dto) {
                        String cogigo = local.getCodigo();
                        String localidade = local.getLocalidade();
                        String endereco = local.getEndereco();
                        String horaInicial = local.getHoraInicioAtendimento();
                        String horaFinal = local.getHoraFinalAtendimento();
                        if (local.getBairro() == "Santana") {
                            imgFoto = R.drawable.santana;
                        } else if (local.getBairro() == "Bela Vista") {
                            imgFoto = R.drawable.belavista;
                        } else if (local.getBairro() == "Tatupé") {
                            imgFoto = R.drawable.tatuape;
                        } else if (local.getBairro() == "Campo Belo") {
                            imgFoto = R.drawable.campobelo;
                        } else if (local.getBairro() == "Praia Grande") {
                            imgFoto = R.drawable.praiagrande;
                        } else if (local.getBairro() == "São Vicente") {
                            imgFoto = R.drawable.saovicente;
                        } else if (local.getBairro() == "Sede") {
                            imgFoto = R.drawable.sede;
                        } else if (local.getBairro() == "SBC") {
                            imgFoto = R.drawable.scb;
                        } else if (local.getBairro() == "Santos") {
                            imgFoto = R.drawable.santos;
                        }else{
                            imgFoto = R.drawable.santos;
                        }

                        Log.d("TESTECHAMADAAPI", "Codigo Teste = " + cogigo);
                        Log.d("TESTECHAMADAAPI", "Localidade Teste = " + localidade);
                        Log.d("TESTECHAMADAAPI", "Endereco Teste = " + endereco);
                        Log.d("TESTECHAMADAAPI", "HoraInicial Teste = " + horaInicial);
                        Log.d("TESTECHAMADAAPI", "Icone Teste = " );
                        Log.d("TESTECHAMADAAPI", "HoraFInal Teste = " + horaFinal);
                        Log.d("TESTECHAMADAAPI", "Foto Teste = " + imgFoto);

                        Endereco loc = new Endereco(cogigo, localidade, endereco, horaInicial, horaFinal, imgFoto);
                        enderecosAdapter.add(loc);
                    }
                    ListaEnderecoAdapter lea = new ListaEnderecoAdapter(CentrosMedicosActivity.this, enderecosAdapter);
                    lvListaEndereco.setAdapter(lea);
                }
            }

            @Override
            public void onFailure(Call<List<Endereco>> call, Throwable t) {
                Log.d("CHAMADAAPI", "Chamada mal sucedida");
                Log.d("CHAMADAAPI", t.toString());
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

    }
}