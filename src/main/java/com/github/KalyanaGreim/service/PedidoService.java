package com.github.KalyanaGreim.service;

import com.github.KalyanaGreim.domain.entity.Pedido;
import com.github.KalyanaGreim.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
