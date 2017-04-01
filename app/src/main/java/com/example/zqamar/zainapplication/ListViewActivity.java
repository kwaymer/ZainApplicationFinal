package com.example.zqamar.zainapplication;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zqamar.zainapplication.adapter.ListViewAdapter;
import com.example.zqamar.zainapplication.adapter.ViewPagerAdapter;
import com.example.zqamar.zainapplication.fragment.ContentFragment;
import com.example.zqamar.zainapplication.fragment.FiveFragment;
import com.example.zqamar.zainapplication.fragment.FourFragment;
import com.example.zqamar.zainapplication.fragment.HistoryFragment;
import com.example.zqamar.zainapplication.fragment.LoginFragment;
import com.example.zqamar.zainapplication.fragment.OneFragment;
import com.example.zqamar.zainapplication.fragment.ThreeFragment;
import com.example.zqamar.zainapplication.fragment.TwoFragment;

import java.util.ArrayList;

/**
 * Created by zqamar on 2/22/17.
 */

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ArrayList<String> listResult;

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>();
        createFakeResult();
        initialView();
    }
    public void createFakeResult() {
        listResult.add("A");listResult.add("B");listResult.add("C");listResult.add("D");listResult.add("E");
        listResult.add("F");listResult.add("G");listResult.add("H");listResult.add("I");listResult.add("J");
        listResult.add("K");listResult.add("L");listResult.add("M");listResult.add("N");listResult.add("O");
        listResult.add("P");listResult.add("Q");
    }
    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);


        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());
        fragmentList.add(new FourFragment());
        fragmentList.add(new FiveFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);


    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"ListView as clicked at position: "+ position, Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity",String.valueOf(position));
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("message","ListView");
        setResult(RESULT_OK, intent);
        super.onBackPressed();

    }

}

