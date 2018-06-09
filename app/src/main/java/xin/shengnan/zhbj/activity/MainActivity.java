package xin.shengnan.zhbj.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.ArrayList;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.fragment.FragmentBase;
import xin.shengnan.zhbj.fragment.FragmentMain;
import xin.shengnan.zhbj.fragment.FragmentMenu;
import xin.shengnan.zhbj.model.NewsCategories;

public class MainActivity extends SlidingFragmentActivity {

    private static final String MENU = "menu";
    private static final String MAIN = "main";

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
        replaceFragment(new FragmentMenu(), R.id.fl_menu, MENU);
        replaceFragment(new FragmentMain(), R.id.fl_main, MAIN);
    }

    private void replaceFragment(FragmentBase fragment, int id, String tag) {
        getSupportFragmentManager().beginTransaction().replace(id, fragment, tag).commit();
    }

    /**
     * 设置侧边栏基本数据
     * */
    private void setMenu() {
        setBehindContentView(R.layout.menu_container);
        SlidingMenu menu = getSlidingMenu();
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setMode(SlidingMenu.LEFT);
        menu.setBehindWidth(300);
    }

    /**
     * 禁止侧边栏
     */
    public void banMenu() {
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
    }

    /**
     *
     * 开启侧边栏
     */
    public void validMenu() {
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }

    /**
     * 侧边栏按钮
     */
    public void clickMenu() {
        getSlidingMenu().toggle();
    }

    public void setMenuData(ArrayList<NewsCategories.MenuListItem> itemList) {
        getMenuFragment().setMenuData(itemList);
    }

    /**
     * 获取FragmentMenu
     * @return
     */
    public FragmentMenu getMenuFragment() {
        return (FragmentMenu) getSupportFragmentManager().findFragmentByTag(MENU);
    };

    /**
     * 获取FragmentMain
     * @return
     */
    public FragmentMain getMainFragment() {
        return (FragmentMain) getSupportFragmentManager().findFragmentByTag(MAIN);
    };

    /**
     * 点击Menu，传递数据给NewsPager
     * @param item
     */
    public void setNewData(NewsCategories.MenuListItem item) {
        getMainFragment().setNewData(item);
        clickMenu();
    }
}
