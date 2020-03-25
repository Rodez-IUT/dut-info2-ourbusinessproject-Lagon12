package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    private InitializationService service;

    public Bootstrap(InitializationService initializationService) {
        service = initializationService;
    }

    public InitializationService getInitializationService() {
        return service;
    }

    @PostConstruct
    public void init() {
        try {
            service.initProjects();
        } catch(RuntimeException err) {
            System.err.println("ERREUR DE RUNTIME : " + err);
        }
    }
}
