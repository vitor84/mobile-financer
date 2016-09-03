package br.com.dotnext.financer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.dotnext.financer.R;
import br.com.dotnext.financer.interfaces.OnCreateOperationListener;
import br.com.dotnext.financer.models.CreateOperationModel;

public class EarnsFragment extends Fragment
        implements OnCreateOperationListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_earns, container, false);
    }

    @Override
    public void onCreateOperation(CreateOperationModel operationModelmodel) {

    }
}
