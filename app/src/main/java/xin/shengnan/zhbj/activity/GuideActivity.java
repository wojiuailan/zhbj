package xin.shengnan.zhbj.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.adapter.GuideAdapter;
import xin.shengnan.zhbj.config.Keys;
import xin.shengnan.zhbj.utils.SharedPreferencesUtil;

public class GuideActivity extends AppCompatActivity {

    private Button btnStart;
    private ViewPager vpGuide;
    private ImageView ivRedPoint;
    private LinearLayout llPointContainer;

    private int pointDis;

    private GuideAdapter guideAdapter;

    private String tag = "GuideActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initUI();
        initData();
        setListener();
    }

    /**
     * 设置按钮监听
     * */
    private void setListener() {
        //按钮监听
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //下次不用再进入GuideActivity
                SharedPreferencesUtil.putBoolean(GuideActivity.this, Keys.FIRST_IN, false);

                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 初始化数据
     * */
    private void initData() {
        //监听布局结束后计算两个灰点的距离
        llPointContainer.getChildAt(1).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                pointDis = llPointContainer.getChildAt(1).getLeft() - llPointContainer.getChildAt(0).getLeft();
            }
        });

        activeRedPoint();

    }

    /**
     * 可移动的红点
     * */
    private void activeRedPoint() {
        vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int MarginLeft = (int) ((position + positionOffset) * pointDis);
                setRelativeMarginLeft(ivRedPoint, MarginLeft);
            }

            @Override
            public void onPageSelected(int position) {
                setRelativeMarginLeft(ivRedPoint, position * pointDis);

                if (2 == position) {
                    btnStart.setVisibility(View.VISIBLE);
                } else {
                    btnStart.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     * 初始化控件
     * */
    private void initUI() {
        btnStart = findViewById(R.id.btn_start);
        vpGuide = findViewById(R.id.vp_guide);
        ivRedPoint = findViewById(R.id.iv_red_point);
        llPointContainer = findViewById(R.id.ll_point_container);

        guideAdapter = new GuideAdapter(GuideActivity.this);
        vpGuide.setAdapter(guideAdapter);

        initPoint();
    }

    /**
     * 初始显示导航点
     * */
    private void initPoint() {
        for (int i = 0; i < guideAdapter.getCount(); i++) {
            ImageView imageView = new ImageView(GuideActivity.this);
            imageView.setBackgroundResource(R.drawable.point_gray);

            if (i > 0) {
                setLinearMarginLeft(imageView, 20);
            }

            llPointContainer.addView(imageView);
        }
    }

    /**
     * 设置线性布局灰点左边距
     * */
    private void setLinearMarginLeft(ImageView imageView, int left) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(left, 0, 0, 0);
        imageView.setLayoutParams(params);
    }

    /**
     * 设置相对布局灰点左边距
     * */
    private void setRelativeMarginLeft(ImageView imageView, int left) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        params.leftMargin = left;
        imageView.setLayoutParams(params);
    }
}
