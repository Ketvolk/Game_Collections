package ru.netology.qa;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Player with name " + name + " is not registered");
    }
}
