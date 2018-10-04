package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText2  ;
    TextView textView;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radioGroup;
    Button button;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;

    int mora_gamer = -1;
    String[] morastring = {"剪刀","石頭","布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText2 =(EditText) findViewById(R.id.editText2);//gamer
        textView = (TextView) findViewById(R.id.textView); //status
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.button); //play
        textView2 = (TextView) findViewById(R.id.textView6);  //name
        textView3 = (TextView) findViewById(R.id.textView7); //win
        textView4 = (TextView) findViewById(R.id.textView8); //my
        textView5 = (TextView) findViewById(R.id.textView9); //
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        mora_gamer=0;
                        break;
                    case R.id.radioButton2:
                        mora_gamer=1;
                        break;
                    case R.id.radioButton3:
                        mora_gamer=2;
                        break;

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText2.getText().toString().equals(""))
                    textView.setText("請選擇玩家名稱");
                else if(mora_gamer==-1)
                    textView.setText("請選擇出拳種類");
                else{
                    textView2.setText(editText2.getText());
                    textView4.setText(morastring[mora_gamer]);
                    int mora_computer = (int) (Math.random() *3);
                    textView5.setText(morastring[mora_computer]);

                    if((mora_gamer==0&&mora_computer ==1) ||(mora_gamer==1&&mora_computer ==2)||(mora_gamer==2&&mora_computer ==0)){
                        textView3.setText("電腦");
                        textView.setText("可惜電腦獲勝了");
                    }
                    else if (mora_gamer==mora_computer){
                        textView3.setText("平局");
                        textView.setText("平局!再試一場");
                    }
                    else{textView3.setText(editText2.getText());
                        textView.setText("");
                    }
                }
            }
        });
    }


}
