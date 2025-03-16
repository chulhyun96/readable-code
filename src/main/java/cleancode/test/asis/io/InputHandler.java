package cleancode.test.asis.io;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String LOCKER_OPTION = "1";

    public String getUserAction() {
        return SCANNER.nextLine();
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return LOCKER_OPTION.equals(userInput);
    }
}
