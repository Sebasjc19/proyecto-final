package co.edu.uniquindio.ingesis.restful.resources;

import co.edu.uniquindio.ingesis.restful.dtos.usuarios.ObtainUsersResponse;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserResponse;
import co.edu.uniquindio.ingesis.restful.exceptions.usuarios.EmailAlredyExistsExceptionMapper;
import co.edu.uniquindio.ingesis.restful.services.interfaces.UserService;
import jakarta.validation.Valid;
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
    UserService userService;
    @DELETE
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") Long id) {
        UserResponse deleteUserResponse = userService.deleteUsuario(id);
        return Response.ok(deleteUserResponse).build();
    }

    @GET
    public Response getUsers() {
        List<ObtainUsersResponse> responseBody = new ArrayList<>();
        //Consultar usuarios en la base de datos
        responseBody.add(new ObtainUsersResponse("James", "Smith", "Jamesito", LocalDate.of(2002, 05, 17), "3214560987"));
        return Response.ok(responseBody).build();
    }

    @GET
    @Path("/{id}")
    public Response getUsuarioById(@PathParam("id") Long id) {
        UserResponse userResponse = userService.getUsuarioById(id);
        return Response.ok(userResponse).build();
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

    @PATCH
    @Path("/{id}")
    public Response updateUserById(@PathParam("id") String id, @Valid UserRegistrationRequest user) {
        if (!id.equals("123")) {
            throw new NotFoundException("No se pudo obtener: Usuario con ID " + id + " no encontrado.");
        }
        return Response.ok("Usuario con ID " + id + " actualizado con éxito.").build();
    }
}