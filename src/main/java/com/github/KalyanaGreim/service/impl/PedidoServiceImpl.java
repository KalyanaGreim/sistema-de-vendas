package com.github.KalyanaGreim.service.impl;

import com.github.KalyanaGreim.domain.entity.Cliente;
import com.github.KalyanaGreim.domain.entity.ItemPedido;
import com.github.KalyanaGreim.domain.entity.Pedido;
import com.github.KalyanaGreim.domain.entity.Produto;
import com.github.KalyanaGreim.domain.repository.Clientes;
import com.github.KalyanaGreim.domain.repository.ItemsPedido;
import com.github.KalyanaGreim.domain.repository.Pedidos;
import com.github.KalyanaGreim.domain.repository.Produtos;
import com.github.KalyanaGreim.exception.RegraNegocioException;
import com.github.KalyanaGreim.rest.dto.ItemPedidoDTO;
import com.github.KalyanaGreim.rest.dto.PedidoDTO;
import com.github.KalyanaGreim.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedido itemsPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar( PedidoDTO dto ) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return repository.findByIdFetchItens(id);
    }


    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem items");
        }
        return items.stream().map( dto -> {
            Integer idProduto = dto.getProduto();
            Produto produto = produtosRepository
                    .findById(idProduto).orElseThrow(() -> new RegraNegocioException(
                            "Código de produto inválido."+ idProduto));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            return itemPedido;
        }).collect(Collectors.toList());
    }
}
