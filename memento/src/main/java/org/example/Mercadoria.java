package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mercadoria {
    private EstadoMercadoria estado;
    private List<EstadoMercadoria> memento = new ArrayList<>();

    public EstadoMercadoria getEstado() {
        return estado;
    }

    public void setEstado(EstadoMercadoria estado) {
        this.estado = estado;
        this.memento.add(estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice >= memento.size()) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = memento.get(indice);
    }

    public List<EstadoMercadoria> getHistoricoEstados() {
        return this.memento;
    }
}