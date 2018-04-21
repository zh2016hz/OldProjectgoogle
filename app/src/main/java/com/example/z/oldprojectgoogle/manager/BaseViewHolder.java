package com.example.z.oldprojectgoogle.manager;

import android.view.View;

/**
 * Created by z on 2018/4/21.
 */

public  abstract  class BaseViewHolder <T>{
    public abstract View inflaterAndFindId();


    public abstract void setData(T t);
}
