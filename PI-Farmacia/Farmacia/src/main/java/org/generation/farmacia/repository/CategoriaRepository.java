package org.generation.farmacia.repository;

import java.util.List;

import org.generation.farmacia.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> { 
	public List<Categoria> findAllByIdadeAlvoContainingIgnoreCase(String idadeAlvo);
	public List<Categoria> findAllByClassificacaoContainingIgnoreCase(String classificacao);
	public List<Categoria> findAllByValidade(double validade);
	
}
