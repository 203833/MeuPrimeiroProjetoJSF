package br.upf.projetojfprimefaces.entity;

import jakarta.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PessoaEntity implements Serializable{

    //atributos...
    private int id;
    private String nome;
    private Date dataNascimento;  
    private String email;   
    private String cidadania;
    private boolean fumante;
    private Integer idade;
    private String observacao;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidadania() {
        return cidadania;
    }

    public void setCidadania(String cidadania) {
        this.cidadania = cidadania;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }  
    
}
