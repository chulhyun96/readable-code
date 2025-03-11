package cleancode.test.asis.service;

import cleancode.test.asis.model.StudyCafePassType;

public interface StudyCafePass {
    StudyCafePassType getPassType();
    int getDuration();
    int getPrice();
}
