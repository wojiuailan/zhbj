package xin.shengnan.zhbj.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ${Li} on 2018/6/9.
 */

public class ViewPagerNewsAdapter extends PagerAdapter {

    private ArrayList<View> viewArrayList;

    public ViewPagerNewsAdapter(ArrayList<View> list) {
        viewArrayList = list;
    }

    @Override
    public int getCount() {
        return viewArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = viewArrayList.get(position);
        container.addView(v);
        return v;
    }
}
