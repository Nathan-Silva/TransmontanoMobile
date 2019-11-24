package com.transmontanomobile.transmontanomobile.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.transmontanomobile.transmontanomobile.R;
import com.transmontanomobile.transmontanomobile.adapters.ListHome;
import com.transmontanomobile.transmontanomobile.adapters.ListaHomeAdapter;
import com.transmontanomobile.transmontanomobile.ui.centros_medicos.CentrosMedicosFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeFragmentListener listener;

    private HomeViewModel homeViewModel;
    ListView lvListaHome;


    public interface HomeFragmentListener {
        void abrirItemDemenu(int posicao);
    }

    public void setHomeFragmentListener( HomeFragmentListener listener){
        this.listener = listener;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  HomeFragmentListener){
            listener = (HomeFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString() + "Não deu certo a implementação");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
             //   textView.setText(s);
            }
        });


        this.lvListaHome = root.findViewById(R.id.lvListaHome);
        ArrayList<ListHome> lista = new ArrayList<>();
        lista.add(new ListHome(1, R.drawable.ic_home_black_24dp, "Boletos"));
        lista.add(new ListHome(2, R.drawable.ic_launcher_foreground, "Consultas"));
        lista.add(new ListHome(3, R.drawable.list_icon_foreground, "Centros Médicos"));
        lista.add(new ListHome(4, R.drawable.ic_dashboard_black_24dp, "Rede de Atendimento"));
        lista.add(new ListHome(5, R.drawable.ic_notifications_black_24dp, "Sair"));


        ListaHomeAdapter lha = new ListaHomeAdapter(getContext(), lista);
        this.lvListaHome.setAdapter(lha);

        lvListaHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.abrirItemDemenu(position);
                Log.d("LOGLISTA", "Clicou no item " + position + "da lista");

            }
        });
        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}