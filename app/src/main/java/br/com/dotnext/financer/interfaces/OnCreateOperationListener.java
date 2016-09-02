package br.com.dotnext.financer.interfaces;

import br.com.dotnext.financer.models.CreateOperationModel;

public interface OnCreateOperationListener {
    void onCreateOperation(CreateOperationModel operationModelmodel);
}
