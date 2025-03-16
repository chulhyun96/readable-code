package cleancode.test.asis.io;

public class InputHandler {

    private static final String LOCKER_OPTION = "1";

    public String getUserAction(String input) {
        return input;
    }

    public boolean getLockerSelection(String input) {
        return LOCKER_OPTION.equals(input);
    }
}
