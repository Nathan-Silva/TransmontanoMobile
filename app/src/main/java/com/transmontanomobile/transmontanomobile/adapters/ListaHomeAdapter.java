package com.transmontanomobile.transmontanomobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.transmontanomobile.transmontanomobile.R;
import com.transmontanomobile.transmontanomobile.model.ListHome;

import java.util.ArrayList;

public class ListaHomeAdapter extends BaseAdapter {

    Context contexto;
    String[] itens;
    Integer[] imagens;
    ArrayList<ListHome> lsHome;


    public ListaHomeAdapter(Context context,ArrayList<ListHome> lsHome) {
        this.contexto = context;
        this.lsHome = lsHome;
    }

    @Override
    public int getCount() {
        return this.lsHome.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lsHome.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  this.lsHome.get(position).getId();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.contexto).inflate(R.layout.item_lista_home, parent, false);
        }
        TextView txtLista = convertView.findViewById(R.id.txtLista);
        ImageView iconeLista = convertView.findViewById(R.id.imgIconeLista);

        ListHome listaHome = this.lsHome.get(position);
        txtLista.setText(listaHome.getDescricao());
        iconeLista.setImageResource(listaHome.getIcone());
        return convertView;
    }
}

