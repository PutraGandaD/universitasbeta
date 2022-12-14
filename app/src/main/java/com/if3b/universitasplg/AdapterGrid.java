package com.if3b.universitasplg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.ClassViewHolder> {
    private ArrayList<ModelUniversitas> dataUniversitas;
    private Context ctx;

    public AdapterGrid(ArrayList<ModelUniversitas> dataPahlawan, Context ctx) {
        this.dataUniversitas = dataPahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_grid, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelUniversitas pahlawan = dataUniversitas.get(position);
        Glide
                .with(ctx)
                .load(universitas.getFoto())
                .centerCrop()
                .into(holder.ivGrid);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xNama, xTentang, xFoto;

                xNama = universitas.getNama();
                xTentang = universitas.getTentang();
                xFoto = universitas.getFoto();
                xLogo = universitas.getLogo();

//                Log.d("CEKNRICEK", xNama+ " | " + xTentang + " | " + xFoto);

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xFoto);
                kirim.putExtra("xLogo", xLogo);

                ctx.startActivity(kirim);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataPahlawan.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGrid;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
        }
    }
}
