package com.example.customlistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

   private TextView tv_mdg,tv_name;
    private ImageView img_gt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_mdg=findViewById(R.id.tv_mdg);
        tv_name=findViewById(R.id.tv_name);
        img_gt=findViewById(R.id.img_gt);
        Bundle ba=getIntent().getExtras();
        String n;
        String t;
        int i;
        i=ba.getInt("key3");
        n=ba.getString("key1");
        t=ba.getString("key2");
        img_gt.setImageResource(i);
        tv_name.setText(t);
        tv_mdg.setText(n);
    }
    }
