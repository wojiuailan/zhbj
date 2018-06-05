package xin.shengnan.zhbj.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.activity.GuideActivity;

/**
 * Created by ${Li} on 2018/6/5.
 */

public class GuideAdapter extends PagerAdapter {

    private int[] guideID = {R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private ArrayList<ImageView> guideView;

    public GuideAdapter(Context context) {
        guideView = new ArrayList<>();
        for (int i = 0; i < guideID.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(guideID[i]);
            guideView.add(imageView);
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = guideView.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return guideView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
