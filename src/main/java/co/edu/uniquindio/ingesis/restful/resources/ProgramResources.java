package co.edu.uniquindio.ingesis.restful.resources;

import co.edu.uniquindio.ingesis.restful.dtos.programs.ProgramCreationRequest;
import co.edu.uniquindio.ingesis.restful.dtos.programs.ProgramUpdateRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/programs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProgramResources {

    @POST
    public Response createProgram(@Valid ProgramCreationRequest programCreationRequest){
        //Verificar que tipo de usuario creo el programa
        //Asiganar fecha de creacion
        //Asiganar fecha de modificacion
        //Asiganar tipo
        return Response.ok("Programa creado con exito").build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProgramById(ProgramUpdateRequest programUpdateRequest){
        //buscar programa por id
        //Actualizar los datos del programa
        //cambiar fecha de modificacion
        return Response.ok("Programa actualizado").build();
    }
}
