package cleancode.test.asis.model;

import cleancode.test.asis.service.StudyCafePass;

import java.util.Objects;

public class StudyCafeLockerPass implements StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public boolean isCompatibleWith(StudyCafeUsingPass pass) {
        return Objects.equals(this.passType, pass.getPassType()) && Objects.equals(this.duration, pass.getDuration());
    }

    public int getPrice() {
        return price;
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }
}
