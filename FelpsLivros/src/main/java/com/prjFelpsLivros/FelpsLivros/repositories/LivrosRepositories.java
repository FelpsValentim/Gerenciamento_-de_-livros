package com.prjFelpsLivros.FelpsLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjFelpsLivros.FelpsLivros.entities.LivrosEntities;

public interface LivrosRepositories extends JpaRepository<LivrosEntities, Long>{


}