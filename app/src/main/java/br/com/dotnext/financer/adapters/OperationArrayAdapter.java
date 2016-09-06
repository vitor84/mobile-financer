package br.com.dotnext.financer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Calendar;

import br.com.dotnext.financer.R;
import br.com.dotnext.financer.models.OperationModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OperationArrayAdapter extends ArrayAdapter<OperationModel> {

    private Context context;

    public OperationArrayAdapter(Context context, int resource) {
        super(context, resource);

        this.context = context;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.row_operation, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        OperationModel model = this.getItem(position);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(model.getCreationDate());

        holder.descriptionTextView.setText(model.getDescription());
        holder.amountTextView.setText(String.valueOf(model.getAmount()));
        holder.instalmentsTextView.setText(String.valueOf(model.getInstalments()));
        //holder.dayTextView.setText(calendar.get(Calendar.DAY_OF_MONTH));
        //holder.monthTextView.setText(calendar.get(Calendar.MONTH));

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.row_operation_description)
        TextView descriptionTextView;

        @BindView(R.id.row_operation_amount)
        TextView amountTextView;

        @BindView(R.id.row_operation_month)
        TextView monthTextView;

        @BindView(R.id.row_operation_day)
        TextView dayTextView;

        @BindView(R.id.row_operation_instalments)
        TextView instalmentsTextView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
