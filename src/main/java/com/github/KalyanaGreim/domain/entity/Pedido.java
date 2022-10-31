package com.github.KalyanaGreim.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne //para referenciar foreign key
    @JoinColumn(name = "cliente_id") //mapeamento de relacionamento entre colunas
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "total", length = 20, precision = 20, scale = 2)
    private BigDecimal total;

    @OneToMany( mappedBy = "pedido")
    private List<ItemPedido> itens;

}
