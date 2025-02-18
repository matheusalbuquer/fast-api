package com.projeto.fast_api.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.projeto.fast_api.entities.Empresa;
import com.projeto.fast_api.entities.ObrigacaoAcessoria;
import com.projeto.fast_api.repositories.EmpresaRepository;
import com.projeto.fast_api.repositories.ObrigacaoAcessoriaRepository;


import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObrigacaoAcessoriaService {
	
	private ObrigacaoAcessoriaRepository obrigacaoRepository;
	
    private  EmpresaRepository empresaRepository;

    public void gerarObrigacoesPadrao(Long empresaId) {
    	
        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow();
        
        List<ObrigacaoAcessoria> obrigacoes = Arrays.asList(
                new ObrigacaoAcessoria("DCTF", "TRIMESTRAL", empresa),
                new ObrigacaoAcessoria("EFD ICMS", "MENSAL", empresa),
                new ObrigacaoAcessoria( "DIRF","ANUAL", empresa)
        );
        obrigacaoRepository.saveAll(obrigacoes);
    }
}
