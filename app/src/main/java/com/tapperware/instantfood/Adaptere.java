package com.tapperware.instantfood;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adaptere extends RecyclerView.Adapter<Adaptere.ViewHolder> {
    Context context;
    String[] productName,productDet;
    int[] productImg;

    public Adaptere(Context context,int[] productImg, String[] productName, String[] productDet) {
        this.context = context;
        this.productDet = productDet;
        this.productName = productName;
        this.productImg = productImg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(productName[i]);
        Glide.with(context).load(productImg[i]).into(viewHolder.imgLogo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, detail.class);
                pindah.putExtra("pn", productName[i]);
                pindah.putExtra("pd", productDet[i]);
                pindah.putExtra("pi", productImg[i]);
                context.startActivity(pindah);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productImg.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtTitle);
        }
    }
}
