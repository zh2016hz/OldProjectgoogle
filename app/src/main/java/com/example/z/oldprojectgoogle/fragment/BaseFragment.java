package com.example.z.oldprojectgoogle.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.z.oldprojectgoogle.view.LoadDataView;

import static android.content.ContentValues.TAG;

/**
 * Created by z on 2018/4/19.
 */

public abstract class BaseFragment extends Fragment {

    private FrameLayout mBaseView;
    private LoadDataView mLoadDataView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mLoadDataView==null){
            mLoadDataView = new LoadDataView(getContext()) {
                @Override
                protected View loadSuccessView() {
                    return showSuccessView();
                }

                @Override
                public int request() {
                    return requestInternet();
                }
            };


        }
        return mLoadDataView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "getItem: item 我是 xxxxxxxx   !!!!!!!!!!!!" );

    }

    protected abstract View showSuccessView();


    public abstract int requestInternet();
    /**
     *  这个请求不能放在生命周期中执行，要单独拿出来
     */
    public  void  doRequest(){
        if(mLoadDataView !=null){
        mLoadDataView.requestData();
        }
    }

}
