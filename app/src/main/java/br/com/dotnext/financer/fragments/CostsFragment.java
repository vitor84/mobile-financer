package br.com.dotnext.financer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.dotnext.financer.R;
import br.com.dotnext.financer.interfaces.OnCreateOperationListener;
import br.com.dotnext.financer.models.CreateOperationModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CostsFragment extends Fragment
        implements OnCreateOperationListener {

    private View costsFragmentView;

    @BindView(R.id.fragment_costs_description_text_view) TextView descriptionTextView;

    @BindView(R.id.fragment_costs_date_text_view) TextView dateTextView;

    @BindView(R.id.fragment_costs_settlement_text_view) TextView settlementTextView;

    @BindView(R.id.fragment_costs_instalments_text_view) TextView instalmentsTextView;

    @BindView(R.id.fragment_costs_amount_text_view) TextView amountTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.costsFragmentView = inflater.inflate(R.layout.fragment_costs, container, false);
        ButterKnife.bind(this, this.costsFragmentView);
        return this.costsFragmentView;
    }

    @Override
    public void onCreateOperation(CreateOperationModel model) {
        bindDataToView(model);
    }

    private void bindDataToView(CreateOperationModel model) {
        descriptionTextView.setText(model.getDescription());
        dateTextView.setText(model.getCreationDate().toString());
        settlementTextView.setText(model.getSettlementDate().toString());
        instalmentsTextView.setText(String.valueOf(model.getInstalments()));
        amountTextView.setText(String.valueOf(model.getAmount()));
    }
}
