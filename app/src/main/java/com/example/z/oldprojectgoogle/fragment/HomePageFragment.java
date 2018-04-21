package com.example.z.oldprojectgoogle.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by z on 2018/4/19.
 */

public class HomePageFragment extends BaseFragment {


    @Override
    protected View showSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("nima");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public int requestInternet() {
        return 0;
    }
}
