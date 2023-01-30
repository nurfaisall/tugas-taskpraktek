package org.acme.controller;

import io.vertx.core.json.JsonObject;
import org.acme.model.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/employee")
public class EmployeeController {

    @GET
    public Response employee(@QueryParam("id")Integer id) {
        List<Employee> result = new ArrayList<>();

        List<Map<String,Object>> end = new ArrayList<>();
        Map<String,Object> body = new HashMap<>();

        List<Employee> findList = Employee.find("id=?1", id).list();
        result.addAll(findList);

        int hasil = 0;

        while (findList != null) {
            for (Employee fL : findList
            ) {
                findList = Employee.find("manager_id=?1", fL.id).list();
                result.addAll(findList);
                if (findList.size() == 0)
                    findList = null;
            }

        }
        for (Employee r: result){
            EmployeeScore find = EmployeeScore.find("id=?1",r.id).firstResult();
            Map<String, Object> employee= new HashMap<>();
            employee.put("name", r.name);
            employee.put("id", r.id);
            employee.put("manager_id",r.managerId);
            employee.put("score",find.score);
            end.add(employee);
            hasil += find.score;

        }
        body.put("employe list",end);
        body.put("rata-rata",hasil / end.size());

        return Response.ok().

    entity(body).

    build();
}
}
