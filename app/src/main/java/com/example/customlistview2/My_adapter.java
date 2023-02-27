package com.example.customlistview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class My_adapter extends BaseAdapter {
    Context context;
    ArrayList<DocGia> datas;

    public My_adapter(Context context, ArrayList<DocGia> datas) {
        this.context = context;
        this.datas = datas;

    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view=inflater.inflate(R.layout.docgialayout, viewGroup, false);
        ImageView img_gt = view.findViewById(R.id.img_gt);
        TextView tv_mdg = view.findViewById(R.id.tv_mdg);
        TextView tv_name = view.findViewById(R.id.tv_name);

        img_gt.setImageResource(datas.get(i).getIdAnh());
        tv_mdg.setText(datas.get(i).getMaDG());
        tv_name.setText(datas.get(i).getTenDG());






//            if(emp.)
//                imgitem.setImageResource(R.drawable.girlicon);
//            else//nếu là Nam thì lấy hình con trai
//                imgitem.setImageResource(R.drawable.boyicon );


        return view;
    }
}