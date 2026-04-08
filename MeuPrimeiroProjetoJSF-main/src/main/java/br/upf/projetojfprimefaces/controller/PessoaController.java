package br.upf.projetojfprimefaces.controller;

import br.upf.projetojfprimefaces.entity.PessoaEntity;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("pessoaController")
@SessionScoped
public class PessoaController implements Serializable {

    public PessoaController() {
    }

    //objeto que representa uma pessoa
    private PessoaEntity pessoa = new PessoaEntity();
    //objeto que representa uma lista de pessoas
    private List<PessoaEntity> pessoaList = new ArrayList<>();

    private PessoaEntity selected;

    //atributo que será utilizado no momento da seleção da linha na datatable
    public PessoaEntity getSelected() {
        return selected;
    }

    public void setSelected(PessoaEntity selected) {
        this.selected = selected;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    public List<PessoaEntity> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<PessoaEntity> pessoaList) {
        this.pessoaList = pessoaList;
    }

    /**
     * Método responsável por gerar um valor para cada registro inserido
     *
     *
     * @return
     */
    private int gerarId() {
        int id = 1;
        if (!pessoaList.isEmpty()) {
            id = pessoaList.size() + 1;
        }
        return id;
    }

    /**
     * Método responsávle por exibir a mensagem no formulário
     */
    private void exibirMensagem() {
        //criando mensagem para exibir...
        String msg = "Contato adicionado: " + pessoa.getNome();
        //capturando mensagem criada...
        FacesMessage fm = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, fm);
    }

    /**
     * Método responsável por adicionar uma pessoa
     */
    public void adicionarPessoa() {
        //adicionando id para o novo registro
        pessoa.setId(gerarId());
        //adicionando um contato dentro da lista de contatos...
        pessoaList.add(pessoa);
        exibirMensagem();
        //limpando os dados da pessoa...
        pessoa = new PessoaEntity();
    }

    /**
     * Método responsável por salvar uma pessoaEntity editada.
     */
    public void editarPessoa() {
        //utilizado para buscar a posição do objeto pessoa que deve ser substituído
        int index = pessoaList.indexOf(selected);
        //substituir na lista o objeto pessoa editado
        pessoaList.set(index, selected);
        //efine o objeto selected como nulo
        selected = null;
        //exibindo mensagem
        FacesMessage fm = new FacesMessage(
                FacesMessage.SEVERITY_INFO, 
                "Sucesso!", 
                "Registro alterado com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    /**
     * Método utilizado para deletar uma pessoa da tabela
     */
    public void deletarPessoa() {
        //utilizado para buscar a posição do objeto pessoa que deve ser substituído
        int index = pessoaList.indexOf(selected);
        //remover da lista o objeto pessoa
        pessoaList.remove(index);
        //efine o objeto selected como nulo
        selected = null;
        //exibindo mensagem
        FacesMessage fm = new FacesMessage(
                FacesMessage.SEVERITY_INFO, 
                "Sucesso!", 
                "Registro excluído com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

}
