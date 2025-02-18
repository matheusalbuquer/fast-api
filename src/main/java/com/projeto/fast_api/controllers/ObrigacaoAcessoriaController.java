package com.projeto.fast_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.fast_api.services.ObrigacaoAcessoriaService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/obrigacoes")
public class ObrigacaoAcessoriaController {

    @Autowired
    private ObrigacaoAcessoriaService obrigacaoService;

    @PostMapping("/gerar/{empresaId}")
    public ResponseEntity<String> gerarObrigacoes(@PathVariable Long empresaId) {
        obrigacaoService.gerarObrigacoesPadrao(empresaId);
        return ResponseEntity.ok("Obrigações geradas com sucesso!");
    }
}

