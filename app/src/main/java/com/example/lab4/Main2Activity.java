package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {
    private Button send_btn;
    private EditText set_drink;
    private RadioGroup rg1,rg2;

    private String sugar_opt = "無糖";
    private String ice_opt = "去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rg1 = findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rd_btn1:
                        sugar_opt = "無糖";
                        break;
                    case R.id.rd_btn2:
                        sugar_opt = "少糖";
                        break;
                    case R.id.rd_btn3:
                        sugar_opt = "半糖";
                        break;
                    case R.id.rd_btn4:
                        sugar_opt = "全糖";
                        break;
                }
            }
        });
        rg2 = findViewById(R.id.radioGroup);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rd_btn5:
                        ice_opt = "去冰";
                        break;
                    case R.id.rd_btn6:
                        ice_opt = "微冰";
                        break;
                    case R.id.rd_btn7:
                        ice_opt = "少冰";
                        break;
                    case R.id.rd_btn8:
                        ice_opt = "正常冰";
                        break;
                }
            }
        });
        send_btn  =findViewById(R.id.btn_send);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_drink = findViewById(R.id.ed_drink);
                String drink = set_drink.getText().toString();
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putString("sugar",sugar_opt);
                b.putString("drink",drink);
                b.putString("ice",ice_opt);
                i.putExtras(b);
                setResult(101,i);
                finish();
            }
        });
    }
}