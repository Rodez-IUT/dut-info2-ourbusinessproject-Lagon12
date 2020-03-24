package ourbusinessproject;

import org.springframework.stereotype.Service;

@Service
public class Bootstrap {

    private InitializationService service;

    public Bootstrap() {
    }

    public Bootstrap(InitializationService initializationService) {
        service = initializationService;
    }

    public InitializationService getInitializationService() {
        return service;
    }


    public void init() {
        try {
            service.initProjects();
        } catch(RuntimeException err) {
            System.err.println("ERREUR DE RUNTIME : " + err);
        }
    }
}
