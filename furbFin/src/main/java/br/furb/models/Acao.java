package br.furb.models;

import br.furb.validators.AcaoValidator;

import java.math.BigDecimal;
import java.util.*;

public class Acao {

    private final String nome;
    private BigDecimal valorAtual;

    private final List<Ordem> compras = new ArrayList<>();
    private final List<Ordem> vendas = new ArrayList<>();
    private final List<UsuarioInvestidor> observadores = new ArrayList<>();

    public Acao(String nome, BigDecimal valorInicial) {
        AcaoValidator validator = new AcaoValidator();
        validator.validar(nome, valorInicial);

        this.nome = Objects.requireNonNull(nome);
        this.valorAtual = Objects.requireNonNull(valorInicial);
    }

    public void adicionarOrdem(Ordem ordem) {
        ordem.adicionarNaAcao(this);
    }

    public void adicionarCompra(Ordem ordem) {
        compras.add(ordem);
    }

    public void adicionarVenda(Ordem ordem) {
        vendas.add(ordem);
    }

    public Optional<Ordem> melhorCompra() {
        return compras.stream().max(Comparator.comparing(Ordem::getValor));
    }

    public Optional<Ordem> melhorVenda() {
        return vendas.stream().min(Comparator.comparing(Ordem::getValor));
    }

    public Ordem removerMelhorCompra() {
        Ordem melhor = melhorCompra().orElse(null);
        if (melhor != null) compras.remove(melhor);
        return melhor;
    }

    public Ordem removerMelhorVenda() {
        Ordem melhor = melhorVenda().orElse(null);
        if (melhor != null) vendas.remove(melhor);
        return melhor;
    }

    public boolean temOrdens() {
        return !compras.isEmpty() && !vendas.isEmpty();
    }

    public void registrarInvestidor(UsuarioInvestidor investidor) {
        observadores.add(investidor);
    }

    public List<UsuarioInvestidor> getObservadores() {
        return Collections.unmodifiableList(observadores);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void atualizarValor(BigDecimal novoValor) {
        this.valorAtual = novoValor;
        observadores.forEach(i -> i.notificar(nome, valorAtual));
    }
}