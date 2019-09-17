package com.example.graphingwidget;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public LineGraphSeries<DataPoint> interestGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chartGraph(view);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void chartGraph(View view) {
        EditText rate = findViewById(R.id.rate);
        EditText amount = findViewById(R.id.amount);

        double r, a, x, y;
        r = Double.parseDouble(rate.getText().toString());
        a = Double.parseDouble(amount.getText().toString());
        x = 0;

        GraphView graph = findViewById(R.id.graph);
        interestGraph = new LineGraphSeries<>();

        for(int i = 0; i < 100; i++) {
            x += .1;
            y = a * (1 + (r * x));
            interestGraph.appendData(new DataPoint(x,y), true, 100);
        }

        graph.addSeries(interestGraph);
    }
}
