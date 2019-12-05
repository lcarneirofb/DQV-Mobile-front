package com.example.dqv;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dqv.fragments.ConsultasFragment;
import com.example.dqv.fragments.HomeFragment;
import com.example.dqv.fragments.ReceitasFragment;
import com.example.dqv.fragments.UserFragment;
import com.example.dqv.fragments.novaConsulta;

public class PageAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ConsultasFragment();
            case 2:
                return new novaConsulta();
            case 3:
                return new ReceitasFragment();
            case 4:
                return new UserFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
