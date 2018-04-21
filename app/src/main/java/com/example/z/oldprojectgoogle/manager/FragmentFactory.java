package com.example.z.oldprojectgoogle.manager;

import android.util.Log;

import com.example.z.oldprojectgoogle.fragment.ApkPageFragment;
import com.example.z.oldprojectgoogle.fragment.BaseFragment;
import com.example.z.oldprojectgoogle.fragment.CategoryFragment;
import com.example.z.oldprojectgoogle.fragment.GamePageFragment;
import com.example.z.oldprojectgoogle.fragment.HomePageFragment;
import com.example.z.oldprojectgoogle.fragment.HotFragment;
import com.example.z.oldprojectgoogle.fragment.RecommendPageFragment;
import com.example.z.oldprojectgoogle.fragment.SubjectPageFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * 保存固定7个页面fragment对象
 */
public class FragmentFactory {

    Map<Integer,BaseFragment> mCaches = new HashMap<Integer,BaseFragment>();

    private static FragmentFactory sInstance;
    private FragmentFactory(){}

    public static FragmentFactory getInstance(){
        if(sInstance == null){
            sInstance = new FragmentFactory();
        }
        return sInstance;
    }

    public BaseFragment getFragment(int position){
        //优先从缓存中取，防止重复
        if(mCaches.get(position)!=null){
            Log.e("MainActivity", "取出fragment");
            return mCaches.get(position);
        }
        BaseFragment fragment = null;
        switch (position){
            case  0:
                fragment = new HomePageFragment();
               break;
            case  1:
                fragment = new ApkPageFragment();
                break;
            case  2:
                fragment = new GamePageFragment();
                break;
            case  3:
                fragment = new SubjectPageFragment();
                break;
            case  4:
                fragment = new RecommendPageFragment();
                break;
            case  5:
                fragment = new CategoryFragment();
                break;
            case  6:
                fragment = new HotFragment();
                break;
        }
        mCaches.put(position,fragment);
        Log.e("MainActivity", "保存fragment");
        return fragment;
    }
}