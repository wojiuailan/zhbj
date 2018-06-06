package xin.shengnan.zhbj.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.fragment.FragmentMain;
import xin.shengnan.zhbj.fragment.FragmentMenu;

public class MainActivity extends SlidingFragmentActivity {

//    private FrameLayout flMenu, flMain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    /**
     * 初始化UI
     * */
    private void initUI() {

        setMenu();//设置侧边栏

        //填充Fragment
        initFragment();
    }

    /**
     * 填充Fragment
     * */
    private void initFragment() {
        replaceFragment(new FragmentMenu(), R.id.fl_menu);
        replaceFragment(new FragmentMain(), R.id.fl_main);
    }

    private void replaceFragment(Fragment fragment, int id) {
        getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    /**
     * 设置侧边栏
     * */
    private void setMenu() {
        setBehindContentView(R.layout.menu_container);
        SlidingMenu menu = getSlidingMenu();
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setMode(SlidingMenu.LEFT);
        menu.setBehindWidth(300);
        menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }
}
