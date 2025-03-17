package cleancode.test.asis.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafeUsingPassTest {




    @Test
    @DisplayName("사용자가 선택한 Pass의 할인된 금액을 반환한다.")
    void getDiscountRateFixed() {
        //given
        StudyCafeUsingPass usingPass = StudyCafeUsingPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1);
        int result = (int) (usingPass.getPrice() * usingPass.getDiscountRate());
        //when
        int discountPrice = usingPass.getDiscountPrice();

        //then
        assertThat(result).isEqualTo(discountPrice);
    }
    @Test
    @DisplayName("사용자가 선택한 Pass의 할인된 금액이 적용된 총 금액을 반환한다.")
    void getTotalPrice() {
        //given
        StudyCafeUsingPass usingPass = StudyCafeUsingPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);

        int totalPassPrice = usingPass.getPrice() + lockerPass.getPrice();
        int result = totalPassPrice - usingPass.getDiscountPrice();
        //when
        int totalPrice = usingPass.getTotalPrice(usingPass.getDiscountPrice(), lockerPass);


        //then
        Assertions.assertThat(result).isEqualTo(totalPrice);
    }
    @Test
    @DisplayName("StudyCafeLockerPass가 null일 경우 0을 반환한다")
    void getTotalPrice1() {
        //given
        StudyCafeUsingPass usingPass = StudyCafeUsingPass.of(StudyCafePassType.FIXED, 4, 100, 0.0);

        //when
        int totalPrice = usingPass.getTotalPrice(20, null);

        //then
        Assertions.assertThat(totalPrice).isEqualTo(80);
    }
}