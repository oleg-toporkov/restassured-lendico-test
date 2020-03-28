package de.lendico.api.exceptions;

public class KeyNotFoundException extends RuntimeException {
    private static final String messageTemplate = "Key %s not found. Please add it to config.yml";

    public KeyNotFoundException(String keyType) {
        super(String.format(messageTemplate, keyType));
    }
}
