package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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

    /* Sauvegarde le projet */
    public void save(Project project) {
        if (project.getEnterprise() != null) {
            project.getEnterprise().addProject(project);
            save(project.getEnterprise());
        }

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
        String requete = "SELECT p FROM Project p ORDER BY p.title";
        TypedQuery<Project> res = entityManager.createQuery(requete, Project.class);
        return res.getResultList();
    }
}
