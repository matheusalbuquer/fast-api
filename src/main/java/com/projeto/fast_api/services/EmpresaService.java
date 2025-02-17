package com.projeto.fast_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projeto.fast_api.dto.EmpresaDTO;
import com.projeto.fast_api.entities.Empresa;
import com.projeto.fast_api.repositories.EmpresaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Service
@Tag(name = "Empresa", description = "Gerenciamento de empresas")
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    @Operation(summary = "Cadastrar nova empresa", description = "Registra uma nova empresa no banco de dados.")
    @ApiResponse(responseCode = "201", description = "Empresa cadastrada com sucesso")
    public Empresa cadastrarEmpresa(EmpresaDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setEndereco(dto.endereco());
        empresa.setEmail(dto.email());
        empresa.setTelefone(dto.telefone());
        return empresaRepository.save(empresa);
    }

    @Operation(summary = "Buscar empresa por ID", description = "Retorna uma empresa pelo seu identificador único.")
    @ApiResponse(responseCode = "200", description = "Empresa encontrada")
    @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    public Empresa buscarEmpresa(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada!"));
    }

    @Transactional
    @Operation(summary = "Atualizar empresa", description = "Atualiza os dados de uma empresa existente.")
    @ApiResponse(responseCode = "200", description = "Empresa atualizada com sucesso")
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
    @Operation(summary = "Deletar empresa", description = "Remove uma empresa do banco de dados.")
    @ApiResponse(responseCode = "204", description = "Empresa deletada com sucesso")
    public void deletarEmpresa(Long id) {
        Empresa empresa = buscarEmpresa(id);
        empresaRepository.delete(empresa);
    }
}
