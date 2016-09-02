package br.com.dotnext.financer.helpers;

import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormHelper {
    public static String getStringForEditText(EditText editText) {
        return editText.getText().toString();
    }

    public static Date getDateForEditText(String formatString, EditText editText) throws ParseException {
        String value = getStringForEditText(editText);
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);

        return dateFormat.parse(value);
    }

    public static Date getDateForEditText(EditText editText) throws ParseException {
        return getDateForEditText("MM/dd/yyyy", editText);
    }

    public static int getIntForEditText(EditText editText) {
        String value = getStringForEditText(editText);
        return Integer.parseInt(value);
    }

    public static float getFloatForEditText(EditText editText) {
        String value = getStringForEditText(editText);
        return Float.parseFloat(value);
    }

    public static double getDoubleForEditText(EditText editText) {
        String value = getStringForEditText(editText);
        return Double.parseDouble(value);
    }
}
