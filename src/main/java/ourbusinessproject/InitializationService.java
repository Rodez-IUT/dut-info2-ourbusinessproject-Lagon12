package ourbusinessproject;

public class InitializationService {
    private Project project1;
    private Project project2;
    private Project project3;
    private Enterprise entreprise1;
    private Enterprise entreprise2;

    public Project getProject1E1() {
        return project1;
    }

    public Project getProject1E2() {
        return project3;
    }

    public Project getProject2E1() {
        return project2;
    }

    public Enterprise getEnterprise1() {
        return entreprise1;
    }

    public Enterprise getEnterprise2() {
        return entreprise2;
    }

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

        project1 = new Project();
        project1.setTitle("projet 1");
        project1.setDescription("p1");
        project1.setEnterprise(entreprise1);

        entreprise1.addProject(project1);
        entreprise2.addProject(project1);

//
        project2 = new Project("projet 2", "p2", entreprise1);
        entreprise1.addProject(project2);

        project3 = new Project("projet 2", "p2", entreprise1);
    }
}
