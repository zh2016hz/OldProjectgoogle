package com.example.z.oldprojectgoogle.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * Created by z on 2018/4/20.
 */

public  class GamePageFragment extends BaseFragment {
    @Override
    protected View showSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("哈哈哈");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public int requestInternet() {
        Log.e(TAG, "哈哈哈哈哈奥或或或或或或或或或或或或或或或或或或或" );
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return 3;
    }


}
