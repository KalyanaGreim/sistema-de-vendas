package com.github.KalyanaGreim.service;

import com.github.KalyanaGreim.domain.entity.Pedido;
import com.github.KalyanaGreim.domain.enums.StatusPedido;
import com.github.KalyanaGreim.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
