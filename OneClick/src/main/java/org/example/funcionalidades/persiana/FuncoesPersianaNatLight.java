package org.example.funcionalidades.persiana;

import br.furb.analise.algoritmos.PersianaNatLight;

/**
 * Regras da biblioteca:
 *  - Só pode subir palheta se ela estiver ABERTA
 *  - Quando palheta erguida, NÃO pode fechar palheta
 */
public class FuncoesPersianaNatLight extends PersianaNatLight implements FuncoesPersiana {

    @Override
    public void abrir() throws Exception {
        if (!estaPalhetaAberta()) {
            super.abrirPalheta();
        }
        super.subirPalheta(); // só funciona se palheta aberta
    }

    @Override
    public void fechar() throws Exception {
        if (estaPalhetaErguida()) {
            super.descerPalheta(); // desce antes de fechar a palheta
        }
        if (estaPalhetaAberta()) {
            super.fecharPalheta();
        }
    }

    @Override
    public boolean estaAberta() {
        return estaPalhetaErguida();
    }
}