package cleancode.test.asis.io;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private static final String LOCKER_OPTION = "1";

    public String getUserAction() {
        return scanner.nextLine();
    }

    public boolean getLockerSelection(String input) {
        return LOCKER_OPTION.equals(input);
    }
}
