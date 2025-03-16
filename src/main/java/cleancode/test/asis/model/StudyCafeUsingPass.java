package cleancode.test.asis.model;

import cleancode.test.asis.service.StudyCafePass;

public class StudyCafeUsingPass implements StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafeUsingPass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafeUsingPass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafeUsingPass(passType, duration, price, discountRate);
    }

    public boolean isEqualTo(StudyCafePassType passType) {
        return this.passType.equals(passType);
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountPrice() {
        return (int) (this.getPrice() * this.discountRate);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getTotalPrice(int discountPrice, StudyCafeLockerPass lockerPass) {
        int lockerPassPrice = lockerPass != null ? lockerPass.getPrice() : 0;
        int totalPassPrice = this.price + lockerPassPrice;
        return totalPassPrice - discountPrice;
    }
}
