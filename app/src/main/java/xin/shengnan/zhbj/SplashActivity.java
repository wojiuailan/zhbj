package xin.shengnan.zhbj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initUI();
        setAnimation();
    }

    /**
     * 初始化UI控件
     * */
    private void initUI() {
        ivSplash = findViewById(R.id.iv_splash);
    }

    private void setAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f);
        RotateAnimation rotateAnimation = new RotateAnimation(0.5f, 1f);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        ivSplash.setAnimation(animationSet);
    }
}
