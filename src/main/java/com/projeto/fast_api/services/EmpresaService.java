package com.projeto.fast_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.fast_api.dto.EmpresaDTO;
import com.projeto.fast_api.entities.Empresa;
import com.projeto.fast_api.repositories.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    public Empresa cadastrarEmpresa(EmpresaDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setEndereco(dto.endereco());
        empresa.setEmail(dto.email());
        empresa.setTelefone(dto.telefone());
        return empresaRepository.save(empresa);
    }

    public Empresa buscarEmpresa(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada!"));
    }

    @Transactional
    public Empresa atualizarEmpresa(Long id, EmpresaDTO dto) {
        Empresa empresa = buscarEmpresa(id);
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setEndereco(dto.endereco());
        empresa.setEmail(dto.email());
        empresa.setTelefone(dto.telefone());
        return empresaRepository.save(empresa);
    }

    @Transactional
    public void deletarEmpresa(Long id) {
        Empresa empresa = buscarEmpresa(id);
        empresaRepository.delete(empresa);
    }
}