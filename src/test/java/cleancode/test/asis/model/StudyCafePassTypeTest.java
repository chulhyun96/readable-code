package cleancode.test.asis.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafePassTypeTest {

    @Test
    @DisplayName("사용자가 1을 입력하면 HOURLY(시간 단위 입력권)이 반환된다.")
    void getHourly() {
        //given
        String userInput = "1";

        //when
        StudyCafePassType from = StudyCafePassType.from(userInput);

        //then
        Assertions.assertThat(from).isEqualTo(StudyCafePassType.HOURLY);
    }
    @Test
    @DisplayName("사용자가 2을 입력하면 WEEKLY(주 단위 이용권)이 반환된다.")
    void getWeekly() {
        //given
        String userInput = "2";

        //when
        StudyCafePassType from = StudyCafePassType.from(userInput);

        //then
        Assertions.assertThat(from).isEqualTo(StudyCafePassType.WEEKLY);
    }
    @Test
    @DisplayName("사용자가 3을 입력하면 FIXED(1인 고정석)이 반환된다.")
    void getFixed() {
        //given
        String userInput = "3";

        //when
        StudyCafePassType from = StudyCafePassType.from(userInput);

        //then
        Assertions.assertThat(from).isEqualTo(StudyCafePassType.FIXED);
    }
}