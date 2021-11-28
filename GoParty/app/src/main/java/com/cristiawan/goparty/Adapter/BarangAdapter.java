package com.cristiawan.goparty.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cristiawan.goparty.DetailTransaksiActivity;
import com.cristiawan.goparty.Item;
import com.cristiawan.goparty.Model.Barang;
import com.cristiawan.goparty.R;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder>{

    Context context;
    List<Barang> barangList;

    public BarangAdapter(Context context, List<Barang> barangList) {
        this.context = context;
        this.barangList = barangList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Barang barang = barangList.get(i);
        viewHolder.tvNama.setText(barang.getNamabarang());
        viewHolder.tvIsi.setText(""+barang.getJumlah());
        viewHolder.tvHarga.setText(barang.getHarga());
        Glide.with(context).load(""+barang.getImgbarang()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(viewHolder.imageView2);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTransaksiActivity.class);
                intent.putExtra("NamaBarang",barang.getNamabarang());
                intent.putExtra("Jumlah",barang.getJumlah());
                intent.putExtra("Harga",barang.getHarga());
                intent.putExtra("imageView2",barang.getImgbarang());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNama, tvIsi, tvHarga;
        ImageView imageView2;

        public ViewHolder(@NonNull View barangView) {
            super(barangView);

            tvNama = barangView.findViewById(R.id.textView5);
            tvHarga = barangView.findViewById(R.id.textView7);
            tvIsi = barangView.findViewById(R.id.textView6);
            imageView2 = barangView.findViewById(R.id.imageView2);

        }
    }
}
