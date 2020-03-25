package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitializationService {
    private Project project1E1;
    private Project project1E2;
    private Project project2E1;
    private Enterprise entreprise1;
    private Enterprise entreprise2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return entreprise1;
    }

    public Enterprise getEnterprise2() {
        return entreprise2;
    }

    @Transactional
    public void initProjects() {
        entreprise1 = new Enterprise();
        entreprise1.setName("entreprise1");
        entreprise1.setDescription("description entreprise1");
        entreprise1.setContactEmail("entreprise1@com.com");
        entreprise1.setContactName("entreprise1 contact name");

        entreprise2 = new Enterprise();
        entreprise2.setName("entreprise2");
        entreprise2.setDescription("description entreprise2");
        entreprise2.setContactEmail("entreprise2@com.com");
        entreprise2.setContactName("entreprise2 contact name");

        project1E1 = new Project("project1E1", "projet1E1 description", entreprise1);
        project1E2 = new Project("project1E2", "projet1E2 description", entreprise2);
        project2E1 = new Project("project2E1", "project2E1 description", entreprise1);

        enterpriseProjectService.save(project1E1);
        enterpriseProjectService.save(project1E2);
        enterpriseProjectService.save(project2E1);
    }
}
