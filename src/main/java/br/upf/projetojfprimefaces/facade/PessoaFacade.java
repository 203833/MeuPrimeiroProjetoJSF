package br.upf.projetojfprimefaces.facade;

import br.upf.projetojfprimefaces.entity.PessoaEntity;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PessoaFacade extends AbstractFacade<PessoaEntity> {

    @PersistenceContext(unitName = "ProjetojfprimefacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaFacade() {
        super(PessoaEntity.class);
    }

    private List<PessoaEntity> entityList;

    public List<PessoaEntity> buscarTodos() {
        entityList = new ArrayList<>();
        try {
            Query query = getEntityManager().createQuery("SELECT p FROM PessoaEntity p order by p.nome");
            if (!query.getResultList().isEmpty()) {
                entityList = (List<PessoaEntity>) query.getResultList();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return entityList;
    }

    public PessoaEntity buscarPorEmail(String email, String senha) {
        PessoaEntity pessoa = new PessoaEntity();
        try {
            Query query = getEntityManager()
                    .createQuery("SELECT p FROM PessoaEntity p WHERE p.email = :email AND p.senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);

            if (!query.getResultList().isEmpty()) {
                pessoa = (PessoaEntity) query.getSingleResult();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return pessoa;
    }
}
