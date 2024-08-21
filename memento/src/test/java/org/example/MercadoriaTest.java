package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MercadoriaTest {
    @Test
    void deveArmazenarEstados() {
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setEstado(new MercadoriaEstadoProcessando());
        mercadoria.setEstado(new MercadoriaEstadoEnviado());
        assertEquals(2, mercadoria.getHistoricoEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setEstado(new MercadoriaEstadoProcessando());
        mercadoria.setEstado(new MercadoriaEstadoEnviado());
        mercadoria.restauraEstado(0);
        assertEquals("Processando", mercadoria.getEstado().getNomeEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setEstado(new MercadoriaEstadoProcessando());
        mercadoria.setEstado(new MercadoriaEstadoEnviado());
        mercadoria.setEstado(new MercadoriaEstadoEmTransporte());
        mercadoria.setEstado(new MercadoriaEstadoEntregue());
        mercadoria.restauraEstado(2);
        assertEquals("Em Transporte", mercadoria.getEstado().getNomeEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Mercadoria mercadoria = new Mercadoria();
            mercadoria.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}