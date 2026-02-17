package com.github.ryurain0309.jhs;

import java.util.logging.Logger;

public class Application {

    Logger logger = Logger.getLogger(getClass().getName());

    public static void main(String[] args) {
        Application app = new Application();
        app.logger.info("Hello, JHS!");
    }
}