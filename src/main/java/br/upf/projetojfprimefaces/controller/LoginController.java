package br.upf.projetojfprimefaces.controller;

import br.upf.projetojfprimefaces.entity.PessoaEntity;
import br.upf.projetojfprimefaces.facade.PessoaFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;

import java.io.Serializable;

@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    
    @Inject
    private PessoaFacade ejbFacade;


    public LoginController() {
    }

    private PessoaEntity pessoa;

    public void prepareAutenticarPessoa() {
        pessoa = new PessoaEntity();
    }

    @PostConstruct
    public void init() {
        prepareAutenticarPessoa();
    }

    public String validarLogin() {
        FacesContext context = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

        PessoaEntity pessoaDB = ejbFacade.buscarPorEmail(pessoa.getEmail(), pessoa.getSenha());
        if ((pessoaDB != null && pessoaDB.getId() != null)) {
            session.setAttribute("pessoaLogada", pessoaDB);

            return "/admin/pessoa.xhtml?faces-redirect=true";
        } else {
            FacesMessage fm = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Falha no login!",
                    "Email ou senha incorreto!"
            );
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

        session.invalidate();

        return "/login.xhtml?faces-redirect=true";
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

}
