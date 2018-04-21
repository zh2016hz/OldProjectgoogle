package com.example.z.oldprojectgoogle.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by z on 2018/4/21.
 */

public class HotFragment extends BaseFragment {
    @Override
    protected View showSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("哈哈哈");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public int requestInternet() {

        Random random = new Random();
        return random.nextInt(3);
    }


}
