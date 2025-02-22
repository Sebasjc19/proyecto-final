package co.edu.uniquindio.ingesis.restful.exceptions.usuarios;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse("User Not Found", exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build();
    }
}