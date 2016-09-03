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

public class CostsFragment extends Fragment
        implements OnCreateOperationListener {

    private View costsFragmentView;

    private TextView descriptionTextView;
    private TextView dateTextView;
    private TextView settlementTextView;
    private TextView instalmentsTextView;
    private TextView amountTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.costsFragmentView = inflater.inflate(R.layout.fragment_costs, container, false);
        return this.costsFragmentView;
    }

    @Override
    public void onCreateOperation(CreateOperationModel model) {
        bindDataToView(model);
    }

    private TextView getDescriptionTextView() {
        if(descriptionTextView == null)
            descriptionTextView = (TextView) costsFragmentView.findViewById(R.id.fragment_costs_description_text_view);
        return descriptionTextView;
    }

    private TextView getDateTextView() {
        if(dateTextView == null)
            dateTextView = (TextView) costsFragmentView.findViewById(R.id.fragment_costs_date_text_view);
        return dateTextView;
    }

    private TextView getSettlementTextView() {
        if(settlementTextView == null)
            settlementTextView = (TextView) costsFragmentView.findViewById(R.id.fragment_costs_settlement_text_view);
        return settlementTextView;
    }

    private TextView getInstalmentsTextView() {
        if(instalmentsTextView == null)
            instalmentsTextView = (TextView) costsFragmentView.findViewById(R.id.fragment_costs_instalments_text_view);
        return instalmentsTextView;
    }

    private TextView getAmountTextView() {
        if(amountTextView == null)
            amountTextView = (TextView) costsFragmentView.findViewById(R.id.fragment_costs_amount_text_view);
        return amountTextView;
    }

    private void bindDataToView(CreateOperationModel model) {
        getDescriptionTextView().setText(model.getDescription());
        getDateTextView().setText(model.getCreationDate().toString());
        getSettlementTextView().setText(model.getSettlementDate().toString());
        getInstalmentsTextView().setText(model.getInstalments());
        getAmountTextView().setText(String.valueOf(model.getAmount()));
    }
}
