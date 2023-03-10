package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Controle;

public class ControleResponseDTO {
    
    private Long id;
    private String nome;
    private Map<String, Object> televisao;


    public ControleResponseDTO(Controle controle) {
        this.id = controle.getId();
        this.nome = controle.getNome();
        this.televisao = new HashMap<String, Object>();
        this.televisao.put("nome", controle.getTelevisao().getMarca());
        this.televisao.put("sigla", controle.getTelevisao().getModelo());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Object> getTelevisao() {
        return televisao;
    }

    public void setTelevisao(Map<String, Object> televisao) {
        this.televisao = televisao;
    }

}
