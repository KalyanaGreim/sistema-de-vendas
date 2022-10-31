package com.github.KalyanaGreim.service.impl;

import com.github.KalyanaGreim.domain.repository.Pedidos;
import com.github.KalyanaGreim.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
