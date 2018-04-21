package com.example.z.oldprojectgoogle.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.z.oldprojectgoogle.FragmentBaseAdapter;
import com.example.z.oldprojectgoogle.R;
import com.example.z.oldprojectgoogle.manager.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by z on 2018/4/19.
 */

public class HomePageFragment extends BaseFragment {

    private ArrayList<String> listData = new ArrayList<>();
    private ListView mListView;
    private View mConvertView;

    @Override
    protected View showSuccessView() {
        mockData();
        mListView = new ListView(getContext());
        mListView.setAdapter(new HomeAdapter(listData));

        return mListView;
    }

    private void mockData() {
        for (int i = 0; i < 50; i++) {
            listData.add(i, "woshi我是第 " + i + "   个数据");
        }
    }

    private class HomeAdapter extends FragmentBaseAdapter {

        public HomeAdapter(ArrayList t) {
            super(t);
        }

        @Override
        public BaseViewHolder getBaseHolder() {
            return new HomeViewHolder();
        }
    }

    @Override
    public int requestInternet() {

        return 0 ;
    }

    private class HomeViewHolder extends BaseViewHolder<String> {
        public TextView homeText;

        @Override
        public View inflaterAndFindId() {
            mConvertView = View.inflate(getContext(), R.layout.home_page_layout_item, null);
            homeText = (TextView) mConvertView.findViewById(R.id.home_page_text);
            return mConvertView;
        }

        @Override
        public void setData(String o) {
            homeText.setText(o);
        }


    }
}
