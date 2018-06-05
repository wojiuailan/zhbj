package xin.shengnan.zhbj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import xin.shengnan.zhbj.activity.GuideActivity;
import xin.shengnan.zhbj.activity.MainActivity;
import xin.shengnan.zhbj.config.Keys;
import xin.shengnan.zhbj.utils.SharedPreferencesUtil;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivSplash;
    private AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initUI();
        setAnimation();
        animationFinish();
    }

    /**
     * 动画结束后
     * */
    private void animationFinish() {
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                nextPage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    /**
     * 跳转下一个页面
     * */
    private void nextPage() {
        if (SharedPreferencesUtil.getBoolean(SplashActivity.this, Keys.FIRST_IN, true)) {
            guidePage();
        } else {
            mainPage();
        }
    }

    /**
     * 跳转到引导页面
     * */
    private void guidePage() {
        Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
        finishSplash(intent);
    }

    /**
     * 跳转到主页面
     * */
    private void mainPage() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        finishSplash(intent);
    }

    public void finishSplash(Intent intent) {
        startActivity(intent);
        finish();
    }

    /**
     * 初始化UI控件
     * */
    private void initUI() {
        ivSplash = findViewById(R.id.iv_splash);
    }

    /**
     * 设置动画
     * */
    private void setAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(2000);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        RotateAnimation rotateAnimation = new RotateAnimation(300f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);

        animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        ivSplash.setAnimation(animationSet);

    }
}
