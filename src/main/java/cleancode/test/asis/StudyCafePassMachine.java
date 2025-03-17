package cleancode.test.asis;

import cleancode.test.asis.exception.AppException;
import cleancode.test.asis.io.InputHandler;
import cleancode.test.asis.io.OutputHandler;
import cleancode.test.asis.model.StudyCafeLockerPass;
import cleancode.test.asis.model.StudyCafePassType;
import cleancode.test.asis.model.StudyCafeUsingPass;
import cleancode.test.asis.service.StudyCafeLockerPassService;
import cleancode.test.asis.service.StudyCafePassService;
import cleancode.test.asis.service.provider.BasicUsingPassProvider;
import cleancode.test.asis.service.provider.LockerPassProvider;

import java.util.List;
import java.util.Scanner;

public class StudyCafePassMachine {

    private static final Scanner SCANNER = new Scanner(System.in);

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    private final BasicUsingPassProvider basicUsingPassProvider;
    private final LockerPassProvider lockerPassProvider;

    private final StudyCafePassService passService;
    private final StudyCafeLockerPassService lockerPassService;

    public StudyCafePassMachine(BasicUsingPassProvider basicUsingPassProvider, LockerPassProvider lockerPassProvider) {
        this.basicUsingPassProvider = basicUsingPassProvider;
        this.lockerPassProvider = lockerPassProvider;
        passService = new StudyCafePassService(basicUsingPassProvider.getStudyCafeUsingPass());
        lockerPassService = new StudyCafeLockerPassService(lockerPassProvider.getStudyCafeLockerPass());
    }

    public void run() {
        try {

            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            StudyCafePassType selectedPassType = selectPassType();
            StudyCafeUsingPass selectedPass = selectPass(selectedPassType);
            handleLockerPass(selectedPass);

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafeUsingPass selectPass(StudyCafePassType passType) {
        List<StudyCafeUsingPass> passes = passService.getPasses(passType);
        outputHandler.showPassListForSelection(passes);

        String userInput = inputHandler.getUserAction();
        return passService.getPass(userInput, passes);
    }

    private boolean selectLockerOption(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
        return inputHandler.getLockerSelection(inputHandler.getUserAction());
    }

    private StudyCafePassType selectPassType() {
        outputHandler.askPassTypeSelection();
        String userInput = inputHandler.getUserAction();
        return StudyCafePassType.from(userInput);
    }

    private void handleLockerPass(StudyCafeUsingPass selectedPass) {
        lockerPassService.findLockerPassBy(selectedPass)
                .filter(this::selectLockerOption)
                .ifPresentOrElse(
                        lockerPass -> outputHandler.showPassOrderSummary(selectedPass, lockerPass),
                        () -> outputHandler.showPassOrderSummary(selectedPass)
                );
    }
}

