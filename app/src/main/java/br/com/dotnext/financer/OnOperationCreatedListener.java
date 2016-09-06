package br.com.dotnext.financer;

import br.com.dotnext.financer.models.OperationModel;

public interface OnOperationCreatedListener {
    void onOperationCreated(OperationModel model);
}
