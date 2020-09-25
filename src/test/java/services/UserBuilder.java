package services;

import models.User;

public class UserBuilder {

    private static final String VALID_NAME = "testtask";
    private static final String VALID_PASSWORD = "12345678";

    public static User getUserWithValidCredentials() {
        return new User(VALID_NAME, VALID_PASSWORD);
    }

    public static User getUserWithoutValidCredentials() {
        return new User();
    }
}
