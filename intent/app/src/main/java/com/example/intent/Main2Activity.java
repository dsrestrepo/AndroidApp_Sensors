package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.renderer.LineChartRenderer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    //    private PieChart pieChart;
    private BarChart barChart;
    private LineChart lineChart;
    private String[]months=new String[]{"enero","febrero","marzo","abril"};
    private int[] data= new  int[]{1,2,3,2};
    private int[] Colors=new int[]{Color.BLACK,Color.RED,Color.GREEN,Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        barChart=(BarChart)findViewById(R.id.barChart);
//        pieChart=(PieChart)findViewById(R.id.pieChart);
        lineChart=(LineChart)findViewById(R.id.lineChart);
        createCharts();

    }
    //personalizar grafica
    private Chart getSameChart(Chart chart,String description,int textColor,int background,int animateY){
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        return chart;
    }
    private void legend(Chart chart){
        Legend legend=chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        ArrayList<LegendEntry> entries=new ArrayList<>();
        for (int i=0; i<months.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = Colors[i];
            entry.label = months[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }

    private ArrayList<BarEntry>getBarEntries(){
        ArrayList<BarEntry>entries=new ArrayList<>();
        for (int i=0; i<data.length; i++)
            entries.add(new BarEntry(i,data[i]));
        return entries;
    }
    private ArrayList<Entry>getLineEntries(){
        ArrayList<Entry>entries=new ArrayList<>();
        for (int i=0; i<data.length; i++)
            entries.add(new Entry(i,data[i]));
        return entries;
    }

    /* private ArrayList<PieEntry>getPieEntries(){
         ArrayList<PieEntry>entries=new ArrayList<>();
         for (int i=0; i<data.length; i++)
             entries.add(new PieEntry(data[i]));
         return entries;
     }*/
    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(months));

    }
    private void axisLeft(YAxis axis){
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);

    }
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }
    public void createCharts(){
        barChart=(BarChart)getSameChart(barChart,"",Color.RED,Color.WHITE,3000);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();;
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());

        lineChart=(LineChart)getSameChart(lineChart,"",Color.RED,Color.WHITE,3000);
        lineChart.setDrawGridBackground(true);
        lineChart.setData(getlineData());
        lineChart.invalidate();;
        axisX(lineChart.getXAxis());
        axisLeft(lineChart.getAxisLeft());
        axisRight(lineChart.getAxisRight());

//        pieChart=(PieChart)getSameChart(pieChart, "",Color.GRAY,Color.WHITE,2000 );
//        pieChart.setHoleRadius(10);
//        pieChart.setTransparentCircleRadius(12);
//        pieChart.setData(getPieData());
//        pieChart.invalidate();
//        //pieChart.setDrawHoleEnabled(false);
    }
    private DataSet getData(DataSet dataSet){
        dataSet.setColors(Colors);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;

    }
    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }
    private LineData getlineData(){
        LineDataSet lineDataSet=(LineDataSet)getData(new LineDataSet(getLineEntries(),""));
        LineData lineData=new LineData(lineDataSet);
        return lineData;
    }



    public void volver (View view){
        Intent volver =new Intent(this, MainActivity.class);
        startActivity(volver);
    }
}
