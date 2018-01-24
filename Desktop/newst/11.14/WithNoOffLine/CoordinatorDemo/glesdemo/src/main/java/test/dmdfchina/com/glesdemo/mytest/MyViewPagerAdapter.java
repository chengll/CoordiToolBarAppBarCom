package test.dmdfchina.com.glesdemo.mytest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by mkt on 2018/1/24.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private  String[] titles;
    private List<Fragment> fragmentDemoList;
    public MyViewPagerAdapter(FragmentManager fm,String[] titles,List<Fragment> fragmentDemoList) {
        super(fm);
        this.titles=titles;
        this.fragmentDemoList=fragmentDemoList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentDemoList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentDemoList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
