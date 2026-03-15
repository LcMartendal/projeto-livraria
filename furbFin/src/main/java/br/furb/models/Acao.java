package br.furb.models;

import java.math.BigDecimal;
import java.util.*;

public class Acao {

    private String nome;
    private BigDecimal valorAtual;

    private PriorityQueue<Ordem> compras;
    private PriorityQueue<Ordem> vendas;

    private List<UsuarioInvestidor> observadores = new ArrayList<>();

    public Acao(String nome, BigDecimal valorInicial) {

        this.nome = nome;
        this.valorAtual = valorInicial;

        compras = new PriorityQueue<>(
                (o1, o2) -> o2.getValor().compareTo(o1.getValor())
        );

        vendas = new PriorityQueue<>(
                Comparator.comparing(Ordem::getValor)
        );
    }

    public void adicionarCompra(Ordem ordem) {
        compras.add(ordem);
    }

    public void adicionarVenda(Ordem ordem) {
        vendas.add(ordem);
    }

    public Ordem melhorCompra() {
        return compras.peek();
    }

    public Ordem melhorVenda() {
        return vendas.peek();
    }

    public Ordem removerMelhorCompra() {
        return compras.poll();
    }

    public Ordem removerMelhorVenda() {
        return vendas.poll();
    }

    public boolean temCompras() {
        return !compras.isEmpty();
    }

    public boolean temVendas() {
        return !vendas.isEmpty();
    }

    public void registrarInvestidor(UsuarioInvestidor investidor) {
        observadores.add(investidor);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }

    public List<UsuarioInvestidor> getObservadores() {
        return observadores;
    }
}
