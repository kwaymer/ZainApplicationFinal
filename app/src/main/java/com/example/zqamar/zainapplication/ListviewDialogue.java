package com.example.zqamar.zainapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zqamar on 3/8/17.
 */

public class ListviewDialogue extends BaseActivity {


    private int checkedID;

    @BindView(R.id.rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.dialog_ok)
    public void onClick() {
        switch (checkedID) {
            case R.id.rb1:
                button1();
                break;
            case R.id.rb2:
                button2();
                break;
            case R.id.cancel_action:
                cancel();
                break;
            default:
        }
    }

    private void button1(){
        Button btn1 = (Button)findViewById(R.id.rb1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(v.getContext(), DialogActivity.class));
            }

        });


    }

    private void button2(){
        Button btn2 = (Button)findViewById(R.id.rb2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(v.getContext(), ListViewActivity.class));
            }

        });
    }

    private void cancel(){
        Button btn3 = (Button)findViewById(R.id.cancel_action);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(v.getContext(), ViewPagerActivity.class));
            }

        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_dialogue);
        ButterKnife.bind(this);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                toastShort("You checked the radio button"+checkedId);
                checkedID = checkedId;
            }
        });
    }
}