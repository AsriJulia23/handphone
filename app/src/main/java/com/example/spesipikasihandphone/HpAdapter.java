package com.example.spesipikasihandphone;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HpAdapter extends RecyclerView.Adapter<HpAdapter.HandphoneHolder>{

    List<Handphone>handphones;
    Activity activity;

    public HpAdapter(List<Handphone> handphones, Activity activity) {
        this.handphones = handphones;
        this.activity = activity;
    }


    @NonNull
    @Override
    public HandphoneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.hp_item,parent,false);
        return  new HandphoneHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HandphoneHolder holder, final int position) {
        holder.txtNama.setText(handphones.get(position).getNama_produk());
        Picasso.with(activity).load(handphones.get(position).getPic()).into(holder.imageView1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handphone hp=handphones.get(position);
                Intent Pindah=new Intent(activity,DetailActivity.class);
                Pindah.putExtra(DetailActivity.KEY_ACTIVITY,hp);
                view.getContext().startActivity(Pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return handphones.size();
    }

    static class HandphoneHolder extends RecyclerView.ViewHolder{
        TextView txtNama;
        TextView txtRam;
        TextView txtInternal;
        TextView txtHarga;
        ImageView imageView1;

        public HandphoneHolder(@NonNull View itemView) {
            super(itemView);
            txtNama=(TextView)itemView.findViewById(R.id.txt_nama_produkItem);
            imageView1=(ImageView)itemView.findViewById(R.id.img_image);

        }
    }

}
