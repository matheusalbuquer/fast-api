package com.projeto.fast_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.fast_api.dto.EmpresaDTO;
import com.projeto.fast_api.entities.Empresa;
import com.projeto.fast_api.services.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {


	    @Autowired
	    private EmpresaService empresaService;

	    @PostMapping
	    public ResponseEntity<Empresa> criarEmpresa( @RequestBody EmpresaDTO dto) {
	        Empresa empresa = empresaService.cadastrarEmpresa(dto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Empresa> buscarEmpresa(@PathVariable Long id) {
	        Empresa empresa = empresaService.buscarEmpresa(id);
	        return ResponseEntity.ok(empresa);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id,  @RequestBody EmpresaDTO dto) {
	        Empresa empresa = empresaService.atualizarEmpresa(id, dto);
	        return ResponseEntity.ok(empresa);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
	        empresaService.deletarEmpresa(id);
	        return ResponseEntity.noContent().build();
	    }
	}


