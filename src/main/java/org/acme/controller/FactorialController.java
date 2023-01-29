package org.acme.controller;

import io.vertx.core.json.JsonObject;
import org.acme.model.Factorial;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class FactorialController {
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Transactional
    public Response factorial(JsonObject payload) {
        // 1 x 2 x 3 x 4
        List<Integer> listNumber = new ArrayList<>();

        int n = payload.getInteger("n");
        int f = 1;
        for (int i = 0; i <= n; i++) {
            Factorial factorial = new Factorial();

            f = f * i;
            if (f <= 0) {
                f = 1;
            }
            listNumber.add(f);
            factorial.n = i;
            factorial.factorial = f;
            factorial.persist();


        }

        return Response.ok().entity(listNumber).build();
    }
}
