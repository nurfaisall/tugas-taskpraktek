package org.acme.controller;


import org.acme.model.Factorial;


import javax.transaction.Transactional;
import javax.ws.rs.*;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/factorial")
public class FactorialController {
    @POST
    @Transactional
    public Response factorial(@QueryParam("n") Integer n) {

        List<Integer> listNumber = new ArrayList<>();

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
