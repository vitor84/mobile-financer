package br.com.dotnext.financer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.dotnext.financer.R;
import butterknife.ButterKnife;

public class CostsFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View TheView = inflater.inflate(R.layout.fragment_costs, container, false);
        ButterKnife.bind(TheView);
        return TheView;
    }


}
