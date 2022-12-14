package com.if3b.UniversitasPLG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.if3b.universitasplg.AdapterCard;
import com.if3b.universitasplg.AdapterGrid;
import com.if3b.universitasplg.DataUniversitas;
import com.if3b.universitasplg.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvUniversitas;
    private ArrayList<ModelUniversitas> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUniversitas = findViewById(R.id.rv_universitas);
        rvUniversitas.setHasFixedSize(true);

        data.addAll(DataUniversitas.ambilDataUniversitas());
        tampilDataCard();
        //tampilDataGrid();
    }

    private void tampilDataCard(){
        rvUniversitas.setLayoutManager(new LinearLayoutManager((this)));
        AdapterCard varAdapterCard = new AdapterCard(dataUniversitas, MainActivity.this);
        rvUniversitas.setAdapter(varAdapterCard);
    }

    private void tampilDataGrid() {
        rvUniversitas.setLayoutManager(new GridLayoutManager(this, 2));
        AdapterGrid varAdapterGrid = new AdapterGrid(data, MainActivity.this);
        rvUniversitas.setAdapter(varAdapterGrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_card, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_mode_card:
                tampilDataCard();
                break;
            case R.id.menu_mode_grid:
                tampilDataGrid();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}