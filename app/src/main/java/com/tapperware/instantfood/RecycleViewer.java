package com.tapperware.instantfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewer extends AppCompatActivity {

    @BindView(R.id.my_recyler_view)
    RecyclerView myRecylerView;

    String[] productName, productDet;
    int[] productImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_viewer);
        ButterKnife.bind(this);
        productName = getResources().getStringArray(R.array.nama_product);
        productDet = getResources().getStringArray(R.array.detail_product);
        productImg = new int[]{R.drawable.campbell, R.drawable.indomie, R.drawable.quacker, R.drawable.samyang, R.drawable.samyang, R.drawable.spaggeti, R.drawable.totino};

        Adaptere adapter = new Adaptere(RecycleViewer.this, productImg, productName, productDet);

        myRecylerView.setHasFixedSize(true);
        myRecylerView.setLayoutManager(new LinearLayoutManager(this));
        myRecylerView.setAdapter(adapter);

    }
}
