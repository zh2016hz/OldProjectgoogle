package com.example.z.oldprojectgoogle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.z.oldprojectgoogle.manager.FragmentFactory;
import com.viewpagerindicator.TitlePageIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private String[] mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        //获取标题
        mTitles = this.getResources().getStringArray(R.array.pagers);
        TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.titles);

        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        indicator.setViewPager(mViewPager);

            }

    private class FragmentAdapter extends FragmentStatePagerAdapter {

        private static final String TAG = "家具";

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           return FragmentFactory.getInstance().getFragment(position);
            /*Fragment  mfragment =null;
            Log.e(TAG, "getItem: item "+position );
          switch (position){
              case 0:
                  mfragment = new HomePageFragment();
                  break;
              case 1:
                  mfragment = new ApkPageFragment();
                  break;
              case 2:
                  mfragment = new HomePageFragment();
                  break;
              default:
                  mfragment= new HomePageFragment();
                  break;
          }

            return mfragment;*/
        }

        @Override
        public int getCount() {
            return mTitles == null ?  0 : mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
           /* if(mTitles !=null){
                return  mTitles[position];
            }
            return super.getPageTitle(position);*/

            return  mTitles[position];
        }
    }

}
