package cleancode.test.asis.io.provider;

import cleancode.test.asis.model.StudyCafePassType;
import cleancode.test.asis.model.StudyCafeUsingPass;
import cleancode.test.asis.service.provider.BasicUsingPassProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BasicUsingPassFileReader implements BasicUsingPassProvider {

    @Override
    public List<StudyCafeUsingPass> getStudyCafeUsingPass() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/pass-list.csv"));
            List<StudyCafeUsingPass> studyCafeUsingPasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                StudyCafeUsingPass studyCafeUsingPass = StudyCafeUsingPass.of(studyCafePassType, duration, price, discountRate);
                studyCafeUsingPasses.add(studyCafeUsingPass);
            }
            return studyCafeUsingPasses;
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }
}
