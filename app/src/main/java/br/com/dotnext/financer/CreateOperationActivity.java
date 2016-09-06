package br.com.dotnext.financer;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.dotnext.financer.enums.OperationTypeEnum;
import br.com.dotnext.financer.helpers.FormHelper;
import br.com.dotnext.financer.models.OperationModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateOperationActivity extends AppCompatActivity {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private final Calendar calendar = Calendar.getInstance();

    public static String CREATE_OPERATION_EXTRA_IDENTIFIER = "E593AAD6-A8A7-48A4-B4FE-25630E1AE74F";

    @BindView(R.id.create_operation_description)
    EditText descriptionEditText;

    @BindView(R.id.create_operation_settlement_date)
    EditText settlementEditText;

    @BindView(R.id.create_operation_date)
    EditText dateEditText;

    @BindView(R.id.create_operation_instalments)
    EditText instalmentsEditText;

    @BindView(R.id.create_operation_amount)
    EditText amountEditText;

    @BindView(R.id.create_operation_type_costs_radioButton)
    RadioButton costsRadioButton;

    @BindView(R.id.create_operation_type_earns_radioButton)
    RadioButton earnsRadioButton;

    @BindView(R.id.create_operation_type_radio_group)
    RadioGroup operationTypeRadioGroup;

    @BindView(R.id.create_operation_toolbar)
    Toolbar mainToolbar;

    DatePickerDialog operationDatePickerDialog;
    DatePickerDialog settlementDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operation);
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        init();
        initOperationDatePicker(mYear, mMonth, mDay);
        initSettlementDatePicker(mYear, mMonth, mDay);
    }

    private void init() {
        instalmentsEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        amountEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    private void initSettlementDatePicker(int mYear, int mMonth, int mDay) {
        settlementDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);
                settlementEditText.setText(dateFormatter.format(calendar.getTime()));
            }
        }, mYear, mMonth, mDay);

        settlementEditText.setInputType(InputType.TYPE_NULL);
        settlementEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settlementDatePickerDialog.show();
                InputMethodManager imputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }

    private void initOperationDatePicker(int mYear, int mMonth, int mDay) {
        operationDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);
                dateEditText.setText(dateFormatter.format(calendar.getTime()));
            }
        }, mYear, mMonth, mDay);

        dateEditText.setInputType(InputType.TYPE_NULL);
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationDatePickerDialog.show();
                InputMethodManager imputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
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
                    setResult(Activity.RESULT_OK, intentResult);
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

    private OperationModel buildModel() throws ParseException {
        String description = FormHelper.getStringForEditText(descriptionEditText);
        double amount = FormHelper.getDoubleForEditText(amountEditText);
        Date date = FormHelper.getDateForEditText(dateEditText);
        Date settlement = FormHelper.getDateForEditText(settlementEditText);
        int instalments = FormHelper.getIntForEditText(instalmentsEditText);

        OperationModel model = new OperationModel();
        model.setDescription(description);
        model.setCreationDate(date);
        model.setSettlementDate(settlement);
        model.setAmount(amount);
        model.setInstalments(instalments);

        switch (operationTypeRadioGroup.getCheckedRadioButtonId()) {
            case R.id.create_operation_type_costs_radioButton:
                model.setType(OperationTypeEnum.COSTS);
                break;
            case R.id.create_operation_type_earns_radioButton:
                model.setType(OperationTypeEnum.EARNS);
                break;
        }

        return model;
    }
}
