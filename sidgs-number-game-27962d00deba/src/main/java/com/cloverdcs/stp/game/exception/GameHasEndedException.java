package com.cloverdcs.stp.game.exception;

public class GameHasEndedException extends Exception {

    public GameHasEndedException() {
        super();
    }

    public GameHasEndedException(String message) {
        super(message);
    }

    public GameHasEndedException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameHasEndedException(Throwable cause) {
        super(cause);
    }

    protected GameHasEndedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
