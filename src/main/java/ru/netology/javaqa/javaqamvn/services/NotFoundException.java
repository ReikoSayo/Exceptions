package ru.netology.javaqa.javaqamvn.services;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
