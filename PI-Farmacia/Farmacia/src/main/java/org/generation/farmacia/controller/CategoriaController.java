package org.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.generation.farmacia.repository.CategoriaRepository;
import org.generation.farmacia.model.Categoria;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository repository;

    // retornar todos os temas existentes
    @GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
    // procurar uma categoria pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// procurar uma categoria pela idade
	@GetMapping("/idade/{idade}")
	public ResponseEntity<List<Categoria>> getByIdadeAlvo(@PathVariable String idadeAlvo){
		return ResponseEntity.ok(repository.findAllByIdadeAlvoContainingIgnoreCase(idadeAlvo));
	}
	
	// procurar uma categoria pela classificacao
	@GetMapping("/classificacao/{classificacao}")
	public ResponseEntity<List<Categoria>> getByClassificacao(@PathVariable String classificacao){
		return ResponseEntity.ok(repository.findAllByClassificacaoContainingIgnoreCase(classificacao));
	}
	
	// procurar uma categoria pela validade
		@GetMapping("/validade/{validade}")
		public ResponseEntity<List<Categoria>> getByValidade(@PathVariable double validade){
			return ResponseEntity.ok(repository.findAllByValidade(validade));
		}
	
    // inserir um novo dado no BD
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(categoria));
	}

    // atualizar dados ja existentes
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.ok(repository.save(categoria));				
	}

    // deletar um dado pelo id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
