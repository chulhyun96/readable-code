package cleancode.test.asis.service;

import cleancode.test.asis.model.StudyCafeUsingPass;
import cleancode.test.asis.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassService {
    private final List<StudyCafeUsingPass> studyCafeUsingPassList;

    public StudyCafePassService(List<StudyCafeUsingPass> studyCafeUsingPassList) {
        this.studyCafeUsingPassList = studyCafeUsingPassList;
    }

    public List<StudyCafeUsingPass> getPasses(StudyCafePassType passType) {
        return this.studyCafeUsingPassList.stream()
                .filter(studyCafePass -> studyCafePass.isEqualTo(passType))
                .toList();
    }

    public StudyCafeUsingPass getPass(String inputOfPass, List<StudyCafeUsingPass> passes) {
        return passes.get(selectedIndex(inputOfPass));
    }

    private int selectedIndex(String inputOfPass) {
        return Integer.parseInt(inputOfPass) - 1;
    }
}
