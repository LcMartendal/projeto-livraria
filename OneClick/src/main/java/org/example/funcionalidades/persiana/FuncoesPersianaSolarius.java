package org.example.funcionalidades.persiana;

import br.furb.analise.algoritmos.PersianaSolarius;

public class FuncoesPersianaSolarius extends PersianaSolarius implements FuncoesPersiana {

    @Override
    public void abrir() {
        super.subirPersiana();
    }

    @Override
    public void fechar() {
        super.descerPersiana();
    }

    @Override
    public boolean estaAberta() {
        return super.estaAberta();
    }
}
