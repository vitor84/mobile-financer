package br.com.dotnext.financer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import br.com.dotnext.financer.adapters.OperationPagerAdapter;
import br.com.dotnext.financer.fragments.CostsFragment;
import br.com.dotnext.financer.fragments.EarnsFragment;
import br.com.dotnext.financer.models.OperationModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
    private static final int CREATE_OPERATION_REQUEST_CODE = 1000;
    private OperationPagerAdapter pagerAdapter;

    private Fragment costsFragment;
    private Fragment earnsFragment;

    @BindView(R.id.activity_main_view_pager_id) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        this.costsFragment = new CostsFragment();
        this.earnsFragment = new EarnsFragment();

        pagerAdapter = new OperationPagerAdapter(getSupportFragmentManager());
        pagerAdapter.add(getResources().getString(R.string.costs_fragment_title), costsFragment);
        pagerAdapter.add(getResources().getString(R.string.earns_fragment_title), earnsFragment);

        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CREATE_OPERATION_REQUEST_CODE:
                if(resultCode == Activity.RESULT_OK) {
                    OperationModel model =
                            (OperationModel) data.getSerializableExtra(
                                    CreateOperationActivity.CREATE_OPERATION_EXTRA_IDENTIFIER);

                    switch (model.getOperationType()) {
                        case COSTS:
                            ((OnOperationCreatedListener)this.costsFragment).onOperationCreated(model);
                            break;
                        case EARNS:
                            ((OnOperationCreatedListener)this.earnsFragment).onOperationCreated(model);
                            break;
                    }
                }
                break;
            default:
        }
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
