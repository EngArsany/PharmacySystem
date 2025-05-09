package com.mycompany.project_draft1;

public final class Exceptions {
    // Private constructor to prevent instantiation
    private Exceptions() {}

    // Exception for insufficient stock
    public static class InsufficientStockException extends Exception {
        public InsufficientStockException(String message) {
            super(message);
        }
    }

    // Exception for item not found
    public static class ItemNotFoundException extends Exception {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }

    
}