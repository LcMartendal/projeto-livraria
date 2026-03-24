package org.example.model.dispositivos.funcionalidades.persiana;

import br.furb.analise.algoritmos.PersianaSolarius;

public class FuncoesPersianaSolarius extends PersianaSolarius implements FuncoesPersiana{

    @Override
    public void abrir() {
        subirPersiana();
    }

    @Override
    public void fechar() {
        descerPersiana();
    }
}
