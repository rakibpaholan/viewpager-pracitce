package com.example.viewpagerpractice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.table_layout_id);
        viewPager = (ViewPager)findViewById(R.id.view_pager_id);

        viewPager.setAdapter(new MyViewPagerClass(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    class MyViewPagerClass extends FragmentPagerAdapter{

        String [] text = {"Bangladesh","Australia","India"};

        public MyViewPagerClass(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            if (position == 0){
                return new Bangladesh();
            }
            if (position==1){
                return new Austrilia();
            }
            if (position==2){
                return new India();
            }
            return null;
        }

        @Override
        public int getCount() {
            return text.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return text[position];
        }
    }
}