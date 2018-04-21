package com.example.z.oldprojectgoogle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.z.oldprojectgoogle.manager.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z on 2018/4/21.
 */

public abstract class FragmentBaseAdapter<T> extends BaseAdapter {
    private List<T> listData;

    public FragmentBaseAdapter(ArrayList<T> t) {
        listData = t;
    }

    @Override
    public int getCount() {
        return listData == null ? 0 : listData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BaseViewHolder baseHolder;
        if (convertView == null) {
            baseHolder = getBaseHolder();
//            convertView = View.inflate(getContext(), R.layout.home_page_layout_item, null);
//            convertView = baseHolder.inflater();
//            homeHolder.homeText = (TextView) convertView.findViewById(R.id.home_page_text);
//            baseHolder.findId();
            convertView = baseHolder.inflaterAndFindId();

            convertView.setTag(baseHolder);
        } else {
            baseHolder = (BaseViewHolder) convertView.getTag();
        }
//        homeHolder.homeText.setText(listData.get(position));
        T t =  listData.get(position);
        baseHolder.setData(t);
        return convertView;
    }

    public abstract BaseViewHolder getBaseHolder();


}
