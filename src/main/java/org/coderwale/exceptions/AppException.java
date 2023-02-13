package org.coderwale.exceptions;

public class AppException extends Throwable {

    public AppException(String s) {
    }

    public class appException extends RuntimeException {
        public appException(String message) {
            super(message);
        }
    }
}
