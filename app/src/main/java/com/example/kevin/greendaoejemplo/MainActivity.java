package com.example.kevin.greendaoejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.kevin.greendaoejemplo.Purposes.Purposes;
import com.example.kevin.greendaoejemplo.Purposes.PurposesAdapter;
import com.example.kevin.greendaoejemplo.Purposes.PurposesController;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PurposesController purposesController = new PurposesController();
        try{
            myReclyclerView = (RecyclerView) findViewById(R.id.mRecycler);
            myAdapter = new PurposesAdapter( purposesController.getAll(), R.layout.purposes_item,new PurposesAdapter.onItemClickListener(){
                @Override
                public void onItemClick(Purposes purpose, int position) {
                    Toast.makeText(MainActivity.this, purpose.getName() + " - "+ position,Toast.LENGTH_LONG).show();

                }
            });
            //todos los tipos de layout manager con los que se puede jugar con el recycler view
            myLayoutManager = new LinearLayoutManager(this);
            //myLayoutManager = new GridLayoutManager(this,2);
            // myLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //solo en caso que sepamos que el tamaño del layout no va a cambiar ahrehgamos esto e incrementa el rendimiento, aunque de nada sirve con el StraggeredGridLayout porque cambia los tamaños
            myReclyclerView.setHasFixedSize(true);
            //animacion por defecto
            myReclyclerView.setItemAnimator(new DefaultItemAnimator());

            myReclyclerView.setLayoutManager(myLayoutManager);
            myReclyclerView.setAdapter(myAdapter);
        }catch(Exception e)
        {
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
            System.out.println("Error :" + e.getMessage());
        }

    }

}
