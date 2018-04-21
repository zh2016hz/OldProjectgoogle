package com.example.z.oldprojectgoogle.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.z.oldprojectgoogle.R;

/**
 * Created by z on 2018/4/21.
 */

public abstract class LoadDataView extends FrameLayout {
    private Context mContext;
    private View mLoadingView;
    private View mErrorView;
    private View mEmptyView;
    private int STATE_SUCCESS = 0;
    private int STATE_LOADING = 1;
    private int STATE_ERROR = 2;
    private int STATE_EMPTY = 3;
    private int STATE_CURRENT;
    private  Handler mHandler = new Handler();
    private View mSuccessView;

    public LoadDataView(@NonNull Context context) {
        super(context);
        mContext = context;
        init();
    }

    public LoadDataView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        mLoadingView = View.inflate(mContext, R.layout.pager_loading, null);
        addView(mLoadingView);
        mErrorView = View.inflate(mContext, R.layout.pager_error, null);
        addView(mErrorView);
        mEmptyView = View.inflate(mContext, R.layout.pager_empty, null);
        addView(mEmptyView);

        controlShow();

    }

    /**
     * 控制这几个异常状态的现实
     */
    private void controlShow() {

        mLoadingView.setVisibility(STATE_CURRENT == STATE_LOADING ? VISIBLE : GONE);
        mErrorView.setVisibility(STATE_CURRENT == STATE_ERROR ? VISIBLE : GONE);
        mEmptyView.setVisibility(STATE_CURRENT == STATE_EMPTY ? VISIBLE : GONE);
        //如果成功的状态
        if(STATE_SUCCESS == STATE_CURRENT && mSuccessView == null){
            mSuccessView = loadSuccessView();
            addView(mSuccessView);
        }
        if(mSuccessView!=null){
        mSuccessView.setVisibility(STATE_CURRENT == STATE_SUCCESS ? VISIBLE : GONE);
        }

    }

    protected abstract View loadSuccessView();

    /**
     * 进行网络请求
     */
    public void requestData() {

        //优化重复请求数据
        if(STATE_CURRENT == STATE_LOADING){
            return;
        }
        STATE_CURRENT = STATE_LOADING;
        controlShow();
        STATE_CURRENT = request();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    STATE_CURRENT = request();
//                    controlShow() ; 直接调用会报错
//                    使用handler
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            controlShow();
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    /**
     * 具体做什么请求
     */
    public abstract int request();
}
