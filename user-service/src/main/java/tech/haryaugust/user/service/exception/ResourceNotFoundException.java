package tech.haryaugust.user.service.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Resource not found on server dude !!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
