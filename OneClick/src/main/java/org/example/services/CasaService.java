package org.example.services;

import org.example.funcionalidades.FuncionalidadesGerais;

public class CasaService implements FuncionalidadesGerais {

    private final PersianaService persianaService;
    private final LampadaService lampadaService;
    private final ArCondicionadoService arCondicionadoService;

    public CasaService(PersianaService persianaService,
                       LampadaService lampadaService,
                       ArCondicionadoService arCondicionadoService) {
        this.persianaService = persianaService;
        this.lampadaService = lampadaService;
        this.arCondicionadoService = arCondicionadoService;
    }

    /**
     * Modo Sono: desliga luzes, desliga ar-condicionado e fecha persianas.
     */
    @Override
    public void modoSono() {
        lampadaService.desligar();
        arCondicionadoService.desligar();
        persianaService.fechar();
    }

    /**
     * Modo Trabalho: liga luzes, liga ar a 25°C e abre persianas.
     */
    @Override
    public void modoTrabalho() {
        lampadaService.ligar();
        arCondicionadoService.ligar();
        arCondicionadoService.definirTemperatura(25);
        persianaService.abrir();
    }
}