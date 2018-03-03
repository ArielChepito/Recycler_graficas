package com.example.kevin.greendaoejemplo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevin.greendaoejemplo.Purposes.Purposes;
import com.example.kevin.greendaoejemplo.Purposes.PurposesController;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


        BarChart barChart = (BarChart) findViewById(R.id.barchart);

        ArrayList<BarEntry> entries = new ArrayList<>();

        PurposesController purposesController = new PurposesController();
        List<Purposes> lista = purposesController.getAll();
        BarDataSet bardataset = new BarDataSet(entries, "Celdas");
        ArrayList<String> labels = new ArrayList<String>();
        for(int x =0; x < lista.size(); x++)
        {
            entries.add(new BarEntry(lista.get(x).getPercentage(), x));
            labels.add(lista.get(x).getName());

        }


        BarData data = new BarData(labels, bardataset);
        barChart.setData(data); // set the data and list of lables into chart

        barChart.setDescription("Propositos para el 2018");  // set the description

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        barChart.animateY(5000);

    }
}
