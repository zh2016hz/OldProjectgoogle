package com.example.z.oldprojectgoogle.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by z on 2018/4/20.
 */

public  class ApkPageFragment extends BaseFragment {
    @Override
    protected View showSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("哈哈哈");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public int requestInternet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return 2;
    }


}
