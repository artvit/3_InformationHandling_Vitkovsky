package by.epam.parsing.exception;

public class ReporterException extends Exception {
    public ReporterException() {
    }

    public ReporterException(String message) {
        super(message);
    }

    public ReporterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReporterException(Throwable cause) {
        super(cause);
    }
}
