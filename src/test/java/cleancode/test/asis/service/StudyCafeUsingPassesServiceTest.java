package cleancode.test.asis.service;

import cleancode.test.asis.model.StudyCafeUsingPass;
import cleancode.test.asis.model.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class StudyCafeUsingPassesServiceTest {
    List<StudyCafeUsingPass> studyCafeUsingPassList = StudyCafeFileHandler.readStudyCafePasses();

    StudyCafePassType hourly = StudyCafePassType.HOURLY;
    StudyCafePassType weekly = StudyCafePassType.WEEKLY;
    StudyCafePassType fixed = StudyCafePassType.FIXED;

    List<StudyCafeUsingPass> hourlyList = this.studyCafeUsingPassList.stream()
            .filter(studyCafePass -> studyCafePass.isEqualTo(hourly))
            .toList();

    List<StudyCafeUsingPass> weeklyList = this.studyCafeUsingPassList.stream()
            .filter(studyCafePass -> studyCafePass.isEqualTo(weekly))
            .toList();

    List<StudyCafeUsingPass> fixedList = this.studyCafeUsingPassList.stream()
            .filter(studyCafePass -> studyCafePass.isEqualTo(fixed))
            .toList();

    @Test
    @DisplayName("")
    void getPasses() {
        //then
        StudyCafeUsingPass studyCafeUsingPass = weeklyList.get(Integer.parseInt("3") - 1);
        System.out.println("studyCafePass = " + studyCafeUsingPass);
    }
}