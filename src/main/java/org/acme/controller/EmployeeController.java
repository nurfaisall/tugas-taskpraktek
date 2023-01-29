package org.acme.controller;

import org.acme.model.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/employee")
public class EmployeeController {

    @GET
    public Response employee(@QueryParam("id")Integer id) {
        System.out.println(id);
        List<Employee> result = new ArrayList<>();

        List<Employee> findList = Employee.find("id=?1", id).list();
        result.addAll(findList);

        while (findList != null) {
            for (Employee fL : findList
            ) {
                findList = Employee.find("manager_id=?1", fL.id).list();
                result.addAll(findList);
                if (findList.size() == 0)
                    findList = null;
            }
        }

        return Response.ok().

    entity(result).

    build();
}
}
