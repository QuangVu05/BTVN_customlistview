package com.example.customlistview2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.Button;
import android.widget.CheckBox;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import android.widget.RadioGroup;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DocGia> DG;;
    EditText edt_id,edt_name;
   RadioGroup rg;
    ImageButton imgbt_delete;
    Button btn_input;
    ListView lv_ds;
    My_adapter adapter;
    int vitri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_id=findViewById(R.id.edt_id);
        edt_name=findViewById(R.id.edt_name);
        rg=findViewById(R.id.rg);
        imgbt_delete=findViewById(R.id.imgbt_delete);
        btn_input=findViewById(R.id.btn_input);
        lv_ds=findViewById(R.id.lv_ds);

        DG=new ArrayList<>();
        DG.add(new DocGia(R.drawable.boyicon,"54474","Nguyễn Quang Vũ"));
        DG.add(new DocGia(R.drawable.boyicon,"5444","Nguyễn Quang Vũ"));
         adapter=new My_adapter(this,DG);
        lv_ds.setAdapter(adapter);
      lv_ds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent inten = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle ba = new Bundle();
                    ba.putInt("key3", DG.get(position).getIdAnh());
                    ba.putString("key1", DG.get(position).getMaDG());
                    ba.putString("key2", DG.get(position).getTenDG());
                    inten.putExtras(ba);
                    startActivity(inten);

                }


      });
//        lv_ds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                    // xử lý sự kiện khi một mục được chọn trong danh sách
//                    Intent inten = new Intent(MainActivity.this, MainActivity2.class);
//                    Bundle ba = new Bundle();
//                    ba.putInt("key3", DG.get(position).getIdAnh());
//                    ba.putString("key1", DG.get(position).getMaDG());
//                    ba.putString("key2", DG.get(position).getTenDG());
//                    inten.putExtras(ba);
//                    startActivity(inten);
//
//                }





        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhap();
            }


        });
        imgbt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoa();
            }
        });



    }

    private void xoa() {
        for(int i=lv_ds.getChildCount()-1;i>=0;i--)
        {
            //lấy ra dòng thứ i trong ListView
            //Dòng thứ i sẽ có 3 phần tử: ImageView, TextView, Checkbox
            View v=lv_ds.getChildAt(i);
            //Ta chỉ lấy CheckBox ra kiểm tra
            CheckBox checkBox =  v.findViewById(R.id.checkbox);
            //Nếu nó Checked thì xóa ra khỏi arrEmployee

            if(checkBox.isChecked())
            {//xóa phần tử thứ i ra khỏi danh sách
                DG.remove(i);
            }
        }

        edt_name.getText().clear();
        edt_id.getText().clear();
        adapter.notifyDataSetChanged();

    }

    private void nhap() {
        String nd = edt_name.getText().toString();
        String nt=edt_id.getText().toString();

        if(rg.getCheckedRadioButtonId()==R.id.rbnam){
            DG.add(new DocGia(R.drawable.boyicon,nt,nd));
        }
        if(rg.getCheckedRadioButtonId()==R.id.rbnu){
            DG.add(new DocGia(R.drawable.girlicon,nt,nd));
        }
        edt_name.getText().clear();
        edt_id.getText().clear();
        adapter.notifyDataSetChanged();


    }


}