package br.com.dotnext.financer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import br.com.dotnext.financer.adapters.OperationPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
    private static final int CREATE_OPERATION_REQUEST_CODE = 1000;

    private OperationPagerAdapter pagerAdapter;

    @BindView(R.id.activity_main_view_pager_id) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        pagerAdapter = new OperationPagerAdapter(getSupportFragmentManager(), getResources());
        viewPager.setAdapter(pagerAdapter);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MainActivity.CREATE_OPERATION_REQUEST_CODE:
                onCreateOperationHandler(data);
                break;
            default:
                return;
        }
    }

    private void onCreateOperationHandler(Intent data) {
//        CreateOperationModel model =
//                (CreateOperationModel) data.getSerializableExtra(
//                        CreateOperationActivity.CREATE_OPERATION_EXTRA_IDENTIFIER);
//
//        Fragment costsFragment =
//                getSupportFragmentManager().findFragmentById(R.id.activity_main_cost_fragment_id);
//
//        ((OnCreateOperationListener)costsFragment).onCreateOperation(model);
    }
}
