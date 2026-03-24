package org.example.model.dispositivos.funcionalidades.persiana;

import br.furb.analise.algoritmos.PersianaNatLight;

public class FuncoesPersianaNatLight extends PersianaNatLight implements FuncoesPersiana{
    @Override
    public void abrir() {
        abrirPalheta();
        abrir();
    }

    @Override
    public void fechar() throws Exception {
        fecharPalheta();
        fechar();
    }
}
