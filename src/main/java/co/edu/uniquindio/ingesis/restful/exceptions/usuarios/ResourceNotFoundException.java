package co.edu.uniquindio.ingesis.restful.exceptions.usuarios;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String usuarioNoEncontrado) {
        super(usuarioNoEncontrado);
    }
}
