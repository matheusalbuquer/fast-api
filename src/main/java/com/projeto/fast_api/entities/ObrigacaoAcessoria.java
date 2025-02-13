package com.projeto.fast_api.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_obgAcessoria")
public class ObrigacaoAcessoria {

	private Long id;
	private String nome;
	private String periodicidade;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false)
	private Empresa empresa;
}
