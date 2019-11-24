package com.transmontanomobile.transmontanomobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.transmontanomobile.transmontanomobile.ui.centros_medicos.CentrosMedicosFragment;
import com.transmontanomobile.transmontanomobile.ui.home.HomeFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity  implements HomeFragment.HomeFragmentListener {

    private HomeFragment homeFragment;
    private CentrosMedicosFragment centrosMedicosFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_alarme, R.id.navigation_carteirinha, R.id.navigation_faleconosco)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if( fragment instanceof HomeFragment){
            HomeFragment homeFragment = (HomeFragment) fragment;
            homeFragment.setHomeFragmentListener(this);
            Log.d("LOGLISTA", "Chegou no Attach Fragment");
        }
    }


    @Override
    public void abrirItemDemenu(int posicao) {
        Log.d("LOGLISTA", "Chegou no metodo impementado na MainActivity");
        /*CentrosMedicosFragment centrosMedicosFragment = (CentrosMedicosFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_centrosmedicos);

            CentrosMedicosFragment newFragment = new CentrosMedicosFragment();
            Bundle args = new Bundle();
            args.putInt("Id", posicao);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.navigation_home, new CentrosMedicosFragment());
            transaction.commit();*/

        Intent it = new Intent(this, CentrosMedicosActivity.class);
        startActivity(it);

    }
}
