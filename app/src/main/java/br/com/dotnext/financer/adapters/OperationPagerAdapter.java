package br.com.dotnext.financer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

public class OperationPagerAdapter extends FragmentPagerAdapter {

    private Dictionary<String, Fragment> fragments;

    public OperationPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        fragments = new Hashtable<>();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Collections.list(fragments.keys()).get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return Collections.list(fragments.elements()).get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void add(String title, Fragment page) {
        fragments.put(title, page);
        notifyDataSetChanged();
    }
}
