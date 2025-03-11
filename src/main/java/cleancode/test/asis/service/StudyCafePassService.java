package cleancode.test.asis.service;

import cleancode.test.asis.model.StudyCafePass;
import cleancode.test.asis.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassService {
    private final List<StudyCafePass> studyCafePassList;

    public StudyCafePassService(List<StudyCafePass> studyCafePassList) {
        this.studyCafePassList = studyCafePassList;
    }

    public List<StudyCafePass> getPasses(StudyCafePassType passType) {
        return this.studyCafePassList.stream()
                .filter(studyCafePass -> studyCafePass.isEqualTo(passType))
                .toList();
    }

    public StudyCafePass getPass(String inputOfPass, List<StudyCafePass> passes) {
        return passes.get(selectedIndex(inputOfPass));
    }

    private int selectedIndex(String inputOfPass) {
        return Integer.parseInt(inputOfPass) - 1;
    }
}
