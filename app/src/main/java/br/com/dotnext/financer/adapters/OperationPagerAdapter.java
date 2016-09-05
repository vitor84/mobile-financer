package br.com.dotnext.financer.adapters;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

import br.com.dotnext.financer.R;
import br.com.dotnext.financer.fragments.CostsFragment;
import br.com.dotnext.financer.fragments.EarnsFragment;

public class OperationPagerAdapter extends FragmentPagerAdapter {

    private Dictionary<String, Fragment> fragments;

    public OperationPagerAdapter(FragmentManager fragmentManager, Resources resources) {
        super(fragmentManager);

        fragments = new Hashtable<>();
        fragments.put(resources.getString(R.string.costs_fragment_title), new CostsFragment());
        fragments.put(resources.getString(R.string.earns_fragment_title), new EarnsFragment());
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
}
