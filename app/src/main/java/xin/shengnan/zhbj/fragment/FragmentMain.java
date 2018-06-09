package xin.shengnan.zhbj.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.activity.MainActivity;
import xin.shengnan.zhbj.adapter.ViewPagerAdapter;
import xin.shengnan.zhbj.model.NewsCategories;
import xin.shengnan.zhbj.pager.ViewPagerBase;
import xin.shengnan.zhbj.pager.ViewPagerHome;
import xin.shengnan.zhbj.pager.ViewPagerNews;
import xin.shengnan.zhbj.view.NoScaleViewPager;

/**
 * Created by ${Li} on 2018/6/6.
 */

public class FragmentMain extends FragmentBase {

    private NoScaleViewPager mVPContainer;
    private ArrayList<View> viewList;
    private RadioGroup mRGBar;

    public ViewPagerBase getVPNews() {
        return mVPNews;
    }

    private ViewPagerBase mVPHome, mVPNews;

    @Override
    protected void initData() {
        mRGBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        openHome();
                        break;
                    case R.id.rb_news:
                        checkViewPager(1);
                        mVPNews.initData();
                        //侧边栏生效
                        validMenu();
                        break;
                    case R.id.rb_setting:
                        break;
                }
            }
        });

        openHome();
    }

    private void openHome() {
        checkViewPager(0);
        mVPHome.initData();
        //禁用Menu
        banMenu();
    }


    /**
     * 禁用Menu
     */
    private void banMenu() {
        //禁用Menu
        ((MainActivity)mActivity).banMenu();
    }

    private void validMenu() {
        //侧边栏生效
        ((MainActivity)mActivity).validMenu();
    }


    private void checkViewPager(int position) {
        mVPContainer.setCurrentItem(position, false);
    }

    @Override
    View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_main, null);
        mVPContainer = v.findViewById(R.id.vp_container);
        mRGBar = v.findViewById(R.id.rg_bar);
        initUI();
        return v;
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        viewList = new ArrayList<>();
        mVPHome = new ViewPagerHome(mActivity);
        mVPNews = new ViewPagerNews(mActivity);
        viewList.add(mVPHome.getRootView());
        viewList.add(mVPNews.getRootView());
        mVPContainer.setAdapter(new ViewPagerAdapter(viewList));
    }

    /**
     * 设置链接网络的数据
     * @param item
     */
    public void setNewData(NewsCategories.MenuListItem item) {
        ((ViewPagerNews)mVPNews).setNewData(item);
    }
}
