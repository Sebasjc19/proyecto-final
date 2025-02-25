package co.edu.uniquindio.ingesis.restful.resources;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.ObtainUsersResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResources {
    @DELETE
    @Path("/{id}")
    public Response deleteUserById(@PathParam("id") String id) {
        if (!id.equals("123")) {
            throw new NotFoundException("No se pudo eliminar: Usuario con ID " + id + " no encontrado.");
        }
        // TODO cambiar por Response.create
        return Response.ok("Usuario con ID " + id + " eliminado con éxito.").build();
    }

    @GET
    public Response getUsers(){
        List<ObtainUsersResponse> responseBody = new ArrayList<>();
        //Consultar usuarios en la base de datos
        responseBody.add(new ObtainUsersResponse("James","Smith","Jamesito", LocalDate.of(2002, 05, 17), "3214560987"));
        return Response.ok(responseBody).build();
    }
}