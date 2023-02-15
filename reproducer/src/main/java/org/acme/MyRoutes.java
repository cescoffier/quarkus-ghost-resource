package org.acme;

import io.quarkus.vertx.web.Route;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyRoutes {

    @Route(methods = Route.HttpMethod.DELETE, path = "/delete")
    String delete() {
        return "deleted";
    }

}
