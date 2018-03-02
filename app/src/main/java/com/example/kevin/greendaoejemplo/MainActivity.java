package com.example.kevin.greendaoejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


     DaoSession daoSession; ///Objeto de la sesion
     PurposesDao purposesDao;  //notasDao sera quien maneje las operaciones de la tabla

    private List<Purposes> purposes;
    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init.getInstance().DeleteAllBases(); //ESTO BORRA TODOS LOS DATOS DE LA BASE, QUITAR!!!!!!!
        daoSession = Init.getInstance().getDaoSession(); //Se recupera la sesion del singleton
        purposesDao = daoSession.getPurposesDao(); //se recupera el manejador de la sesion
        /*Aquí inserto una lista de datos en la base de datos*/

        purposesDao.insertInTx(getAllPurposes());

        try{
            purposes= this.purposesDao.loadAll();//aquí lo mando a llamar
            myReclyclerView = (RecyclerView) findViewById(R.id.mRecycler);
            myAdapter = new PurposesAdapter(purposes, R.layout.item_purposes,new PurposesAdapter.onItemClickListener(){
                @Override
                public void onItemClick(Purposes purpose, int position) {
                    Toast.makeText(MainActivity.this, purpose.getName() + " - "+ position,Toast.LENGTH_LONG).show();
                    //deleteMovie(position);

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
            System.out.println("nose :" + e.getMessage());
        }







    }
    private List<Purposes> getAllPurposes(){
        return new ArrayList<Purposes>(){{
            add(new Purposes(1L,"Correr","Correr",0.25));
            add(new Purposes(2L,"Aprender ingles","exit o",0.25));
            add(new Purposes(3L,"Aprender linux","sudo su",0.25));



        }};
    }
}
