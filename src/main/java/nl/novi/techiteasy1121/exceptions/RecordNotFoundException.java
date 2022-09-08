package nl.novi.techiteasy1121.exceptions;

public class RecordNotFoundException extends RuntimeException {
//    private static final long serialVersionUID = 1L; (dit is om te serializen)
    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}

