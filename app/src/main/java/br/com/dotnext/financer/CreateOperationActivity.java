package br.com.dotnext.financer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.text.ParseException;
import java.util.Date;

import br.com.dotnext.financer.helpers.FormHelper;
import br.com.dotnext.financer.models.CreateOperationModel;

public class CreateOperationActivity extends Activity {
    private static String CREATE_OPERATION_EXTRA_IDENTIFIER = "E593AAD6-A8A7-48A4-B4FE-25630E1AE74F";

    private EditText descriptionEditText;
    private EditText settlementEditText;
    private EditText dateEditText;
    private EditText instalmentsEditText;
    private EditText amountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_create_operation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean handled = true;

        switch (item.getItemId()) {
            case R.id.menu_activity_create_operation_ok:
                Intent intentResult = new Intent();
                try {
                    intentResult.putExtra(CREATE_OPERATION_EXTRA_IDENTIFIER, buildModel());
                    finish();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.menu_activity_create_operation_cancel:
                finish();
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }

        return handled;
    }

    private CreateOperationModel buildModel() throws ParseException {
        String description = FormHelper.getStringForEditText(getDescriptionEditText());
        double amount = FormHelper.getDoubleForEditText(getAmountEditText());
        Date date = FormHelper.getDateForEditText(getDateEditText());
        Date settlement = FormHelper.getDateForEditText(getSettlementEditText());
        int instalments = FormHelper.getIntForEditText(getInstalmentsEditText());

        CreateOperationModel model = new CreateOperationModel();
        model.setDescription(description);
        model.setCreationDate(date);
        model.setSettlementDate(settlement);
        model.setAmount(amount);
        model.setInstalments(instalments);

        return model;
    }

    private EditText getDescriptionEditText() {
        if(descriptionEditText == null)
            descriptionEditText = (EditText) findViewById(R.id.create_operation_description);
        return descriptionEditText;
    }

    private EditText getSettlementEditText() {
        if(settlementEditText == null)
            settlementEditText = (EditText) findViewById(R.id.create_operation_settlement_date);
        return settlementEditText;
    }

    private EditText getDateEditText() {
        if(dateEditText == null)
            dateEditText = (EditText) findViewById(R.id.create_operation_date);
        return dateEditText;
    }

    private EditText getInstalmentsEditText() {
        if(instalmentsEditText == null)
            instalmentsEditText = (EditText) findViewById(R.id.create_operation_instalments);
        return instalmentsEditText;
    }

    private EditText getAmountEditText() {
        if(amountEditText == null)
            amountEditText = (EditText) findViewById(R.id.create_operation_amount);
        return amountEditText;
    }
}
