package cleancode.test.asis.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputHandlerTest {


    @Test
    @DisplayName("사용자로부터 받은 입력이 LOCKER_OPTION과 같다면 true를 반환한다.")
    void getLockerSelectionReturnTrue() {
        //given
        String lockerOption = "1";
        String input = "1";
        //when
        boolean equals = lockerOption.equals(input);
        //then
        assertThat(equals).isTrue();
    }

    @Test
    @DisplayName("사용자로부터 받은 입력이 LOCKER_OPTION과 다르다면 false를 반환한다.")
    void getLockerSelectionReturnFalse() {
        //given
        String lockerOption = "2";
        String input = "1";
        //when
        boolean equals = lockerOption.equals(input);
        //then
        assertThat(equals).isFalse();
    }
}