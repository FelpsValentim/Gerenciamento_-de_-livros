package com.prjFelpsLivros.FelpsLivros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prjFelpsLivros.FelpsLivros.entities.LivrosEntities;
import com.prjFelpsLivros.FelpsLivros.repositories.LivrosRepositories;

@Service
public class LivrosService {

	private final LivrosRepositories livrosRepositories;

	public LivrosService(LivrosRepositories livrosRepositories) {
		this.livrosRepositories = livrosRepositories;
	}

	public LivrosEntities getLivroById(Long id) {
		return livrosRepositories.findById(id).orElse(null);
	}

	public LivrosEntities saveLivro(LivrosEntities livrosEntities) {
		return livrosRepositories.save(livrosEntities);
	}

	public void deleteLivros(Long id) {
		livrosRepositories.deleteById(id);
	}

	public List<LivrosEntities> getAllLivrosEntities() {
		return livrosRepositories.findAll();
	}

	public LivrosEntities updateLivro(Long id, LivrosEntities novoLivro) {
		Optional<LivrosEntities> livroOptional = livrosRepositories.findById(id);
		if (livroOptional.isPresent()) {
			LivrosEntities livroExistente = livroOptional.get();
			livroExistente.setDescrição(novoLivro.getDescrição());
			livroExistente.setIsbn(novoLivro.getIsbn());
			return livrosRepositories.save(livroExistente);
		} else {
			return null;
		}
	}

}
