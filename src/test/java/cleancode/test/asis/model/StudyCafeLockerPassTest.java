package cleancode.test.asis.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassTest {

    @Test
    @DisplayName("사용자가 선택한 StudyCafeUsingPass 이용권이 LockerPass의 passType과 duration이 같으면 true를 반환한다.")
    void isCompatibleWithTrue() {
        //given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 250000);
        StudyCafeUsingPass usingPass = StudyCafeUsingPass.of(StudyCafePassType.FIXED, 4, 250000, 0.0);
        //when
        boolean compatibleWith = lockerPass.isCompatibleWith(usingPass);
        //then
        assertThat(compatibleWith).isTrue();
    }

    @Test
    @DisplayName("사용자가 선택한 StudyCafeUsingPass 이용권이 LockerPass의 passType과 duration이 다르면 false를 반환한다.")
    void isCompatibleWithFalse() {
        //given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 250000);
        StudyCafeUsingPass usingPass = StudyCafeUsingPass.of(StudyCafePassType.HOURLY, 4, 250000, 0.0);
        //when
        boolean compatibleWith = lockerPass.isCompatibleWith(usingPass);
        //then
        assertThat(compatibleWith).isFalse();
    }

}