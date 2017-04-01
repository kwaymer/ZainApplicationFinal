package com.example.zqamar.zainapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.zqamar.zainapplication.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener {

    private ImageButton topRightButton;
    private ImageButton topLeftButton;
    private ImageButton bt1;
    private ImageButton bt3;
    private GestureDetector mGestureDetector;

    private Button animator;

    private Button timer;

    @BindView(R.id.main_fl) FrameLayout fl;


    @OnClick(R.id.main_animator_bt)
    public void animatorButtonClick(){
        Intent i = new Intent(this, AnimatorActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.listview_dialogue)
    public void listViewDialogue(){
        Intent i = new Intent(this, ListviewDialogue.class);
        startActivity(i);
    }


    //@OnClick(R.id.bt_animation)
    //public void toAnimation() {
    //   toAnimation(AnimationActivity.class);

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent i = new Intent(this, DialogActivity.class);
        startActivityForResult(i, 2);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this,new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialListener(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button 1", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(v.getContext(), ViewPagerActivity.class);
                i.putExtra("key", "value");
                Bundle b = new Bundle();
                b.putInt("Ingeter", 12345);

                Book book = new Book();
                book.setName("Book's Name");
                book.setAuthor("Book's Author");
                b.putSerializable("book", book);

                i.putExtras(b);
                startActivityForResult(i, 1);

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toastShort("Button 3");

                Intent i = new Intent(v.getContext(), ListViewActivity.class);
                startActivityForResult(i, 3);

            }
        });

        topLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        topRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LaunchViewActivityA.class);
                startActivity(intent);
            }
        });
    }

    private void initialView() {
        bt1 = (ImageButton)findViewById(R.id.bt1);
        bt3 = (ImageButton)findViewById(R.id.bt3);
        topLeftButton = (ImageButton)findViewById(R.id.topLeftButton);
        topRightButton = (ImageButton)findViewById(R.id.topRightButton);
    }

    public void onClick(View v){
        Toast.makeText(this,"Button 2 was Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{

            public boolean onDown(MotionEvent e){
                UtilLog.logD("MyGesture", "onDown");
                toastShort( "onDown");
                return true;
            }

            public void onShowPress(MotionEvent e) {
                UtilLog.logD("MyGesture", "onShowPress");
                toastShort( "onShowPress");
            }

            public void onLongPress(MotionEvent e){
                UtilLog.logD("MyGesture", "OnLongPress");
                toastShort( "onLongPress");
            }

            public boolean onSingleTapUp(MotionEvent e){
                toastShort( "onSingleTapUp");
                return true;
            }

            public boolean onScrollTapConfirmed(MotionEvent e){
                toastShort( "onSingleTapConfirmed");
                return true;
            }

            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
                UtilLog.logD("MyGesture" , "onScroll:" + (e2.getX() - e1.getX()) + "   "+ distanceX);
                toastShort( "onScroll");
                return true;
            }

            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
                UtilLog.logD("MyGesture", "OnFling");
                toastShort( "onFling");
                return true;
            }

            public boolean onDoubleTap(MotionEvent e){
                toastShort( "onDoubleTap");
                return true;
            }

    }

    }





