package com.cloverdcs.stp.game.exception;

public class MaxGuessExceededException extends Exception {

    public MaxGuessExceededException() {
        super();
    }

    public MaxGuessExceededException(String message) {
        super(message);
    }

    public MaxGuessExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxGuessExceededException(Throwable cause) {
        super(cause);
    }

    protected MaxGuessExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
