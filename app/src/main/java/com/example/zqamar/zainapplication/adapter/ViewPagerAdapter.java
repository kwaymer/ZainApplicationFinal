package com.example.zqamar.zainapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zqamar on 2/23/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setContent(ArrayList<Fragment> fragmentArrayList) {
        this.fragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position){
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        super.destroyItem(container,position,object);}

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        return super.instantiateItem(container, position);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentArrayList.get(position).getClass().getName();
    }


}
