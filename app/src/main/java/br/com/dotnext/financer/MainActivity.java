package br.com.dotnext.financer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {
    private static int CREATE_OPERATION_REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean handled = true;

        switch (item.getItemId()) {
            case R.id.menu_activity_main_create_operation:
                Intent createOperationIntent = new Intent(this, CreateOperationActivity.class);
                startActivityForResult(createOperationIntent, CREATE_OPERATION_REQUEST_CODE);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }

        return handled;
    }
}
