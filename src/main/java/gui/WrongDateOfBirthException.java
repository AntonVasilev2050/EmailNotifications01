package gui;

public class WrongDateOfBirthException extends Exception {
    private final String message = "Wrong date of birth";

    @Override
    public String getMessage() {
        return message;
    }
}
