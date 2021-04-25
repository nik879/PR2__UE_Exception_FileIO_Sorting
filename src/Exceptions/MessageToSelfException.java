package Exceptions;

public class MessageToSelfException extends MessengerException {
    public MessageToSelfException() {
    }

    public MessageToSelfException(String message) {
        super(message);
    }

    public MessageToSelfException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageToSelfException(Throwable cause) {
        super(cause);
    }

    public MessageToSelfException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
