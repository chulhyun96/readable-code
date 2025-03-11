package cleancode.test.asis.service;

import cleancode.test.asis.model.StudyCafeLockerPass;
import cleancode.test.asis.model.StudyCafeUsingPass;
import cleancode.test.asis.model.StudyCafePassType;

import java.util.List;
import java.util.Optional;

public class StudyCafeLockerPassService {

    private final List<StudyCafeLockerPass> lockerPasses;

    public StudyCafeLockerPassService(List<StudyCafeLockerPass> lockerPasses) {
        this.lockerPasses = lockerPasses;
    }

    public Optional<StudyCafeLockerPass> findLockerPassBy(StudyCafeUsingPass selectedPass) {
        if (selectedPass.isEqualTo(StudyCafePassType.FIXED)) {
            return this.lockerPasses.stream()
                    .filter(lockerPass -> lockerPass.isCompatibleWith(selectedPass))
                    .findFirst();
        }
        return Optional.empty();
    }
}
