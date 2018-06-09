package xin.shengnan.zhbj;

import android.app.Application;

import org.xutils.x;

/**
 * Created by ${Li} on 2018/6/8.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
