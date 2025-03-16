package cleancode.test.asis.io;

import cleancode.test.asis.service.StudyCafePass;
import cleancode.test.asis.model.StudyCafeLockerPass;
import cleancode.test.asis.model.StudyCafeUsingPass;
import cleancode.test.asis.model.StudyCafePassType;

import java.util.List;

public class OutputHandler {

    public void showWelcomeMessage() {
        System.out.println("*** 프리미엄 스터디카페 ***");
    }

    public void showAnnouncement() {
        System.out.println("* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)");
        System.out.println("* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)");
        newLine();
    }

    public void askPassTypeSelection() {
        System.out.println("사용하실 이용권을 선택해 주세요.");
        System.out.println("1. 시간 이용권(자유석) | 2. 주단위 이용권(자유석) | 3. 1인 고정석");
    }

    public void showPassListForSelection(List<StudyCafeUsingPass> passes) {
        newLine();
        System.out.println("이용권 목록");
        for (int index = 0; index < passes.size(); index++) {
            StudyCafeUsingPass pass = passes.get(index);
            System.out.println(String.format("%s. ", index + 1) + display(pass));
        }
    }

    public void askLockerPass(StudyCafeLockerPass lockerPass) {
        newLine();
        String askMessage = String.format(
                "사물함을 이용하시겠습니까? (%s)",
                display(lockerPass)
        );

        System.out.println(askMessage);
        System.out.println("1. 예 | 2. 아니오");
    }

    public void showPassOrderSummary(StudyCafeUsingPass basicPass) {
        showPassOrderSummary(basicPass, null);
    }

    public void showPassOrderSummary(StudyCafeUsingPass basicPass, StudyCafeLockerPass lockerPass) {
        newLine();
        System.out.println("이용 내역");
        System.out.println("이용권: " + display(basicPass));
        if (lockerPass != null) {
            System.out.println("사물함: " + display(lockerPass));
        }

        int discountPrice = basicPass.getDiscountPrice();
        if (isHigherThanZero(discountPrice)) {
            System.out.println("이벤트 할인 금액: " + discountPrice + "원");
        }

        int totalPrice = basicPass.getTotalPrice(discountPrice, lockerPass);
        System.out.println("총 결제 금액: " + totalPrice + "원");
        newLine();
    }

    private boolean isHigherThanZero(double discountPrice) {
        return discountPrice > 0;
    }

    public void showSimpleMessage(String message) {
        System.out.println(message);
    }

    public String display(StudyCafePass selectedPass) {
        StudyCafePassType passType = selectedPass.getPassType();
        int duration = selectedPass.getDuration();
        int price = selectedPass.getPrice();

        if (passType == StudyCafePassType.HOURLY) {
            return String.format("%s시간권 - %d원", duration, price);
        }
        if (passType == StudyCafePassType.WEEKLY) {
            return String.format("%s주권 - %d원", duration, price);
        }
        if (passType == StudyCafePassType.FIXED) {
            return String.format("%s주권 - %d원", duration, price);
        }
        return "";
    }

    private void newLine() {
        System.out.println();
    }
}
