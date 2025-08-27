package com.example.demo.command;

public interface Command {
    Long getId();
    String getDescription();
    void execute();
}
