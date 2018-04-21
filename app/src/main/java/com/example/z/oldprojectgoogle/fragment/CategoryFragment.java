package com.example.z.oldprojectgoogle.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.z.oldprojectgoogle.R;

import java.util.Random;

/**
 * Created by z on 2018/4/21.
 */

public class CategoryFragment  extends BaseFragment {
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
        Random random = new Random();
        return random.nextInt(3);
    }


}

