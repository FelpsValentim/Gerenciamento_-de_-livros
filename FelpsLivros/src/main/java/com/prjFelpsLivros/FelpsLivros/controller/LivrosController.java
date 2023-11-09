package com.prjFelpsLivros.FelpsLivros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjFelpsLivros.FelpsLivros.entities.LivrosEntities;
import com.prjFelpsLivros.FelpsLivros.service.LivrosService;

@RestController
@RequestMapping("/Livros")
public class LivrosController {
	
	private final LivrosService livrosService;
	
	
		@GetMapping("/home")
		public String paginaInicial() {
			return "index"; // Nome do seu arquivo HTML (sem a extensão)
		}		

		@Autowired
		public LivrosController(LivrosService livrosService) {
			this.livrosService = livrosService;
		}

		@PostMapping
		public LivrosEntities createLivro(@RequestBody LivrosEntities livrosEntities) {
			return livrosService.saveLivro(livrosEntities);
		}

		@GetMapping("/{id}")
		public ResponseEntity<LivrosEntities> getLivro(@PathVariable Long id) {
			LivrosEntities livrosEntities = livrosService.getLivroById(id);
			if (livrosEntities != null) {
				return ResponseEntity.ok(livrosEntities);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping
		public ResponseEntity<List<LivrosEntities>> getAllJogos(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<LivrosEntities> jogos = livrosService.getAllLivrosEntities();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(jogos);
		}

		@PutMapping("/{id}")
		public LivrosEntities updateJogo(@PathVariable Long id, @RequestBody LivrosEntities livrosEntities) {
			return livrosService.updateLivro(id, livrosEntities);
		}

		@DeleteMapping("/{id}")
		public void deleteJogo(@PathVariable Long id) {
			livrosService.deleteLivros(id);
		}

	
}
