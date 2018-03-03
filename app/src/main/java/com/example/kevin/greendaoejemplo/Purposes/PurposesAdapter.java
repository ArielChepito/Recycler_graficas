package com.example.kevin.greendaoejemplo.Purposes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kevin.greendaoejemplo.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Ariel on 02/03/2018.
 */

public class PurposesAdapter extends RecyclerView.Adapter<PurposesAdapter.ViewHolder>{


    private List<Purposes> purposesList;
    private int layout;
    private onItemClickListener listener;

    public PurposesAdapter(List<Purposes> Purposes, int layout, onItemClickListener listener) {
        this.purposesList = Purposes;
        this.layout = layout;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inlfamos el layout y le pasamos lso datos al constructor del view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //llamamos al metodo bind del viewholder pasandole el objdeto y un listener
        holder.bind(purposesList.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return purposesList.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //Elementos UI a rellenar
        public TextView name;
        public TextView description;
        public Button prompPurpose;
        public ProgressBar progressBar;

        public ViewHolder(View v){

            //recibe la vista completa para que la rendericemos, pasamos parametros a constructor padre
            // aqui tambien manejamos los datos de logioca para extraer datos y hacer referencias con los elementoss
            super(v);
            this.name =(TextView) v.findViewById(R.id.purposeName);
            this.description = (TextView) v.findViewById(R.id.purposeDesc);
            this.prompPurpose = v.findViewById(R.id.prompPurpose);
            this.progressBar = v.findViewById(R.id.progressBarPercen);

        }

        public void bind(final Purposes Purposes, final  onItemClickListener listener){
            //procesamos los datos para renderizar
            String date = new SimpleDateFormat("dd-MM-yyyy").format( Purposes.getDate());
            name.setText(Purposes.getName());
            description.setText(Purposes.getDescription());
            // this.textViewPurposes.setText(Purposes.getName());
            /// definimos que por cada elemento del recycler view tenemos un listener que se va a comportart de la siguiente manera
            progressBar.setProgress(Purposes.getPercentage());
            prompPurpose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(Purposes, getAdapterPosition());
                }
            });

        }

    }
    ///declaramos las interfaces con los metodos a implementar
    public interface onItemClickListener{
        void onItemClick(Purposes Purposes, int position);
    }
}
