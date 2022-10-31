package com.github.KalyanaGreim.domain.repository;

import com.github.KalyanaGreim.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
