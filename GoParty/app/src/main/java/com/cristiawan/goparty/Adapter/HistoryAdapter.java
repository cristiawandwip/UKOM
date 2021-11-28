package com.cristiawan.goparty.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cristiawan.goparty.DetailTransaksiActivity;
import com.cristiawan.goparty.Item;
import com.cristiawan.goparty.Model.Barang;
import com.cristiawan.goparty.Model.History;
import com.cristiawan.goparty.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    Context context;
    List<History> historyList;

    public HistoryAdapter(Context context, List<History> itemList) {
        this.context = context;
        this.historyList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        History item = historyList.get(i);
        viewHolder.tvNama.setText(item.getTglorderawal());
        viewHolder.tvIsi.setText(item.getTglorderakhir());
        viewHolder.tvHarga.setText(item.getJumlah());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTransaksiActivity.class);
                intent.putExtra("Tglorderawal",item.getTglorderawal());
                intent.putExtra("Tglorderakhir",item.getTglorderakhir());
                intent.putExtra("Jumlah",item.getJumlah());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNama, tvIsi, tvHarga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.textView5);
            tvHarga = itemView.findViewById(R.id.textView7);
            tvIsi = itemView.findViewById(R.id.textView6);

        }
    }
}
