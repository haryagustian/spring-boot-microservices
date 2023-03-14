package tech.haryaugust.hotel.service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource Not Found Dude !!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
