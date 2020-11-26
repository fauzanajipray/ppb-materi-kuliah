package com.udinus.recycleview_11330;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterNama extends RecyclerView.Adapter<AdapterNama.NamaViewHolder> {

    @NonNull
    @Override
    public NamaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.tampilan_nama, viewGroup, false);
        return new NamaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamaViewHolder namaViewHolder, int i) {
        String title = dataNama [i];
        namaViewHolder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return dataNama.length;
    }

    public class NamaViewHolder  extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;
        public NamaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        }
    }

    private String[] dataNama;

    public AdapterNama(String[] dataNama){
        this.dataNama=dataNama;
    }

}
