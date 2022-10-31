package com.github.KalyanaGreim.rest.controller;

import com.github.KalyanaGreim.domain.entity.Pedido;
import com.github.KalyanaGreim.rest.dto.PedidoDTO;
import com.github.KalyanaGreim.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}
