package br.unitins.dto;



public class ControleDTO {
   
    private String nome;
    private Long idTelevisao;
    
    public String getNome() {
        return nome;
    }
    public Long getIdTelevisao() {
        return idTelevisao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdTelevisao(Long idTelevisao) {
        this.idTelevisao = idTelevisao;
    }

}
