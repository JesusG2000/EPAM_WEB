package com.epam.examples.math.command;

import com.epam.examples.controller.Command;

public class WrongRequest implements Command<String> {



    @Override
    public String execute(String data) {
        return "wrong request";
    }

    @Override
    public Class getInputType() {
        return null;
    }
}
