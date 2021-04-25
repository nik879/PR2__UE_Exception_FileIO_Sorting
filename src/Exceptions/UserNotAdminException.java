package Exceptions;

public class UserNotAdminException extends MessengerException {
    public UserNotAdminException() {
    }

    public UserNotAdminException(String message) {
        super(message);
    }

    public UserNotAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotAdminException(Throwable cause) {
        super(cause);
    }

    public UserNotAdminException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
