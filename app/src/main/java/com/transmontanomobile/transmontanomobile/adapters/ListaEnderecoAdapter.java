package com.transmontanomobile.transmontanomobile.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.transmontanomobile.transmontanomobile.ExibeCentrosMedicosActivity;
import com.transmontanomobile.transmontanomobile.R;
import com.transmontanomobile.transmontanomobile.model.Endereco;

import java.util.ArrayList;

public class ListaEnderecoAdapter extends BaseAdapter {

    Context contexto;
    ArrayList<Endereco> lsEndereco;


    private TextView txtNome;
    private TextView txtEndereco;
    private TextView txtSemana;
    private TextView txtHora;
    private ImageView iconeLocal;
    private ImageView imgLocal;
    private Button btnComoChegar;

    public ListaEnderecoAdapter(Context contexto, ArrayList<Endereco> endereco) {
        this.contexto = contexto;
        this.lsEndereco = endereco;
    }


    @Override
    public int getCount() {
        return this.lsEndereco.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lsEndereco.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(this.lsEndereco.get(position).getCodigo());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.contexto).inflate(R.layout.item_lista_centros_medicos, parent, false);
        }
        Log.d("VERIFICANDOLISTAENDERECO", "Passou pelo getView!");
        this.txtNome = convertView.findViewById(R.id.txtNome);
        this.txtEndereco = convertView.findViewById(R.id.txtEndereco);
        this.txtSemana = convertView.findViewById(R.id.txtSemana);
        this.txtHora = convertView.findViewById(R.id.txtHora);
        this.iconeLocal = convertView.findViewById(R.id.iconeLocal);
        this.imgLocal = convertView.findViewById(R.id.imgLocal);
        this.btnComoChegar = convertView.findViewById(R.id.btnComoChegar);

        final Endereco listaEndereco = this.lsEndereco.get(position);
        txtNome.setText(listaEndereco.getLocalidade());
        txtEndereco.setText(listaEndereco.getEndereco());
        txtSemana.setText("Segunda à Sexta");
        txtHora.setText(listaEndereco.getHoraInicioAtendimento() + " às " + listaEndereco.getHoraFinalAtendimento());
        iconeLocal.setImageResource(R.drawable.iconemap);
        imgLocal.setImageResource(listaEndereco.getImgFoto());

        this.btnComoChegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TESTEBOTAOLISTA", "Passou pelo OnClick Adapter na posição = " + position);
                Intent it = new Intent(ListaEnderecoAdapter.this.contexto, ExibeCentrosMedicosActivity.class);
                it.putExtra("ID", listaEndereco.getCodigo());
                Log.d("TESTEBOTÃOLISTA", "Codigo enviado = " + listaEndereco.getCodigo());
                contexto.startActivity(it);
            }
        });
        return convertView;
    }
}

