package com.projeto.fast_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ObrigacaoAcessoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    /*
    @Enumerated(EnumType.STRING)
    private Periodicidade periodicidade;*/

    private String periodicidade;
    
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;
    
    public ObrigacaoAcessoria(String nome,String periodicidade , Empresa empresa) {
        this.nome = nome;
        this.periodicidade = periodicidade;
        this.empresa = empresa;
    }

}
