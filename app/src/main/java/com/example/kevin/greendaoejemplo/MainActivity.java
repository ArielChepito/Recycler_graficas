package com.example.kevin.greendaoejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.kevin.greendaoejemplo.Purposes.Purposes;
import com.example.kevin.greendaoejemplo.Purposes.PurposesAdapter;
import com.example.kevin.greendaoejemplo.Purposes.PurposesController;
import com.example.kevin.greendaoejemplo.Purposes.PurposesDialog;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    PurposesController purposesController;
    List<Purposes> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            purposesController = new PurposesController();
            lista = purposesController.getAll();
            myReclyclerView = (RecyclerView) findViewById(R.id.mRecycler);
            myAdapter = new PurposesAdapter( lista, R.layout.purposes_item,new PurposesAdapter.onItemClickListener(){
                @Override
                public void onItemClick(final Purposes purpose, int position) {
                    PurposesDialog.showDialog(
                            MainActivity.this,
                            purpose,
                            "Modificar",
                            "Datos: ",
                            R.drawable.ic_launcher_background,
                            "Modificar",
                            "Eliminar",
                            "Cancelar",
                            false,
                            new PurposesDialog.onDataReadyListener() {
                                @Override
                                public void onDataReady(Purposes Purposes, int opt) {
                                    MainActivity.this.crud(opt,purpose);
                                }
                            });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_crear:
                final Purposes purpose = new Purposes();
                PurposesDialog.showDialog(
                        MainActivity.this,
                        purpose,
                        "Guardar",
                        "Datos: ",
                        R.drawable.ic_launcher_background,
                        "Guardar",
                        "",
                        "Cancelar",
                        false,
                        new PurposesDialog.onDataReadyListener() {
                            @Override
                            public void onDataReady(Purposes Purposes, int opt) {
                                MainActivity.this.crud(opt,purpose);
                            }
                        });

                return true;
            case R.id.item_grafica:
                Intent intent = new Intent(this,Graph.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void crud(int op, Purposes purposes)
    {
        switch (op)
        {
            case 1:
                this.purposesController.save(purposes);
                break;
            case 2:
                this.purposesController.update(purposes);
                break;
            case 3:
                this.purposesController.delete(purposes);
        }

        lista.clear();
        lista.addAll(purposesController.getAll());
        this.myAdapter.notifyDataSetChanged();
    }

}
