package co.edu.uniquindio.ingesis.restful.resources;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restful.exceptions.usuarios.EmailAlredyExistsExceptionMapper;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    @Path("/{id}")
    public Response getUserById(@PathParam("id") String id) {
        if (!id.equals("123")) {
            throw new NotFoundException("No se pudo obtener: Usuario con ID " + id + " no encontrado.");
        }
        return Response.ok("Usuario con ID " + id + " encontrado.").build();
    }
    @POST
    public Response createUser(@Valid UserRegistrationRequest user) {
        /*
         * Implementar logica de validación con base de datos
         * Validación si no existe otro email igual en la BD
         * Implementar logica de guardado de passwords con JWT
         */
        if (user.email().equals("correoprueba@email.com")){
            throw new RuntimeException("El email "+user.email()+" ya está registrado");
        }
        return Response.ok("Usuario con correo "+user.email()+" creado con éxito.").build();
    }
}