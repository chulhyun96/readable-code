package cleancode.test.asis.model;

import cleancode.test.asis.exception.AppException;

import java.util.Arrays;

public enum StudyCafePassType {

    HOURLY("1", "시간 단위 이용권"),
    WEEKLY("2", "주 단위 이용권"),
    FIXED("3", "1인 고정석");

    private final String type;
    private final String description;

    StudyCafePassType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static StudyCafePassType from(String userInput) {
        return Arrays.stream(values())
                .filter(cafePassType -> cafePassType.isEqualTo(userInput))
                .findFirst()
                .orElseThrow(() -> new AppException("잘못된 입력입니다"));
    }

    private boolean isEqualTo(String userInput) {
        return this.type.equals(userInput);
    }
}
