package ru.bellintegrator.practice;

public class MyError extends Exception {

    private final String message;

    public MyError(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\r\n\"error\":\"" + message + "\"\r\n}";
    }
}
