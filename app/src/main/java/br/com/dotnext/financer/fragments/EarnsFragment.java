package br.com.dotnext.financer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.dotnext.financer.OnOperationCreatedListener;
import br.com.dotnext.financer.R;
import br.com.dotnext.financer.adapters.OperationArrayAdapter;
import br.com.dotnext.financer.models.OperationModel;

public class EarnsFragment extends Fragment implements OnOperationCreatedListener {

    private OperationArrayAdapter listViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earns, container, false);

        listViewAdapter = new OperationArrayAdapter(getContext(), R.layout.row_operation);
        ListView listView = (ListView) view.findViewById(R.id.fragment_earns_list_view_id);
        listView.setAdapter(listViewAdapter);

        return view;
    }

    @Override
    public void onOperationCreated(OperationModel model) {
        listViewAdapter.add(model);
        listViewAdapter.notifyDataSetChanged();
    }
}
