package org.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Categoria")

public class Categoria { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotBlank
	@Size(min = 1, max = 50 , message = "O atributo idade Alvo deve ter no min 1 caracteres")
	private String idadeAlvo;
	
	@NotBlank
	@Size(min = 2, max = 50, message = "O atributo classificação deve ter no minimo 2 caracteres")
	private String classificacao;
	
    @NotNull
	private double validade;   
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL )
    @JsonIgnoreProperties("categoria")
    private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdadeAlvo() {
		return idadeAlvo;
	}

	public void setIdadeAlvo(String idadeAlvo) {
		this.idadeAlvo = idadeAlvo;
	}

	public String getClassificação() {
		return classificacao;
	}

	public void setClassificação(String classificação) {
		this.classificacao = classificação;
	}

	public double getValidade() {
		return validade;
	}

	public void setValidade(double validade) {
		this.validade = validade;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	} 
	
    
    
}
