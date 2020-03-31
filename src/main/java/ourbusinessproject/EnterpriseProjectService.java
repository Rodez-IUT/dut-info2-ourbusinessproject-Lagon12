package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Project project) {
        entityManager.persist(project.getEnterprise());
        entityManager.persist(project);
        entityManager.flush();
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
        entityManager.flush();
    }

    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class, anId);
    }

    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }

    public List<Project> findAllProjects() {
        /*
           1 : 2 requêtes identiques sont générées (seul le paramètre change)
           2 : Elles retournent les informations des entreprises
           3 : Ce sont les informations des entreprises liés au projet
           4 : Ces informations ne sont pas retournés dans la première requête
               car il n'y a pas de jointure juste une référence (clé étrangère) aux entreprises dans celle-ci
         */
        String query = "SELECT p FROM Project p ORDER BY p.title" ;
        TypedQuery<Project> queryObj = entityManager.createQuery(query,Project.class);
        return queryObj.getResultList();
    }
}