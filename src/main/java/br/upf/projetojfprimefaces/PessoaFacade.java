package br.upf.projetojfprimefaces;

import br.upf.projetojfprimefaces.entity.PessoaEntity;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Stateless
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
}
