package xin.shengnan.zhbj.pager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.activity.MainActivity;
import xin.shengnan.zhbj.adapter.ViewPagerNewsAdapter;
import xin.shengnan.zhbj.config.Keys;
import xin.shengnan.zhbj.model.NewsCategories;
import xin.shengnan.zhbj.pager.news.PagerNews;
import xin.shengnan.zhbj.pager.news.PagerSpecial;

/**
 * Created by ${Li} on 2018/6/7.
 */

public class ViewPagerNews extends ViewPagerBase {
    private ViewPager mVPNews;
    private PagerNews mPagerNews;
    private PagerSpecial mPagerSpecial;
    private ArrayList<View> mViewList;

    private ViewPagerNewsAdapter mVPNewsAdapter;

    private NewsCategories mData;

    private static final String PAGER_NEWS = "pager_news";

    public ViewPagerNews(Activity activity) {
        super(activity);
    }

    /**
     *
     */
    public void initData() {
        setTitleText("新闻");//设置监听
        getIBMenu().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().clickMenu();
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                loadStringData();
            }
        }).start();
    }

    @Override
    public View initView(Activity activity) {
        View v = View.inflate(activity, R.layout.view_pager_news, null);
        mVPNews = v.findViewById(R.id.vp_news_container);
        return v;
    }


    /**
     * 加载数据
     */
    private void loadStringData() {
        RequestParams params = new RequestParams(Keys.IO_CATEGORIES);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {            }

            @Override
            public void onCancelled(CancelledException cex) {}

            @Override
            public void onFinished() {}
        });
    }

    /**
     * 解析JSon
     * @param result
     */
    private void processData(String result) {
        Gson gsong = new Gson();
        mData = gsong.fromJson(result, NewsCategories.class);


        handler.sendEmptyMessage(0);
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            initPager();
        }
    };

    private void initPager() {
        //为MenuFragment，设置数据
        getActivity().setMenuData(mData.data);
        //初始化内容页面
        mPagerNews = new PagerNews(getActivity());
        mPagerSpecial = new PagerSpecial(getActivity());

        mViewList = new ArrayList<>();
        mViewList.add(mPagerNews.getRootView());
        mViewList.add(mPagerSpecial.getRootView());
        mVPNewsAdapter = new ViewPagerNewsAdapter(mViewList);
        mVPNews.setAdapter(mVPNewsAdapter);

        //初始化默认页
        openNews(mData.data.get(0));
    }

    /**
     * 设置链接网络的数据
     * @param item
     */
    public void setNewData(NewsCategories.MenuListItem item) {
        switch (item.id) {
            case Keys.NEWS_ID:
                openNews(item);
                break;
            case Keys.SPECIAL_ID:
                openSpecial(item);
                break;
        }
    }

    private void openSpecial(NewsCategories.MenuListItem item) {
        mPagerSpecial.initData(item);
        mVPNews.setCurrentItem(1, false);
        setTitleText(item.title);
    }

    /**
     * 初始化开启News
     * @param item
     */
    private void openNews(NewsCategories.MenuListItem item) {
        mPagerNews.initData(item);
        mVPNews.setCurrentItem(0, false);
        setTitleText(item.title);
    }
}
