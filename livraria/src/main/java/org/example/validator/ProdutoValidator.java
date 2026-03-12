package org.example.validator;

public class ProdutoValidator implements Validador<String> {

    @Override
    public void validar(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }
    
}
