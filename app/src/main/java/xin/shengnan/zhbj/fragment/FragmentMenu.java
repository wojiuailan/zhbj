package xin.shengnan.zhbj.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xin.shengnan.zhbj.R;

/**
 * Created by ${Li} on 2018/6/6.
 */

public class FragmentMenu extends FragmentBase {

    @Override
    protected void initData() {

    }

    @Override
    View initView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_menu, null);
    }
}
