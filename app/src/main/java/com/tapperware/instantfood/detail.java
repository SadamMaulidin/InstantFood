package com.tapperware.instantfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class detail extends AppCompatActivity {

    @BindView(R.id.imgList)
    ImageView imgList;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


        txtTitle.setText(getIntent().getStringExtra("pn"));
        txtDetail.setText(getIntent().getStringExtra("pd"));
        Glide.with(this).load(getIntent().getIntExtra("pi", 0)).into(imgList);
    }
}
