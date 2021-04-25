package Exceptions;

public class UserOfflineException extends MessengerException {
    public UserOfflineException() {
    }

    public UserOfflineException(String message) {
        super(message);
    }

    public UserOfflineException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserOfflineException(Throwable cause) {
        super(cause);
    }

    public UserOfflineException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
