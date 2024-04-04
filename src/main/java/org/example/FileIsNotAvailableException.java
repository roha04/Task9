package org.example;

public class FileIsNotAvailableException extends Throwable {
    public FileIsNotAvailableException() {
        super("File is not available.");
    }
}
