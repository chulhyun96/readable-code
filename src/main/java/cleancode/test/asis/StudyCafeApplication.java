package cleancode.test.asis;


import cleancode.test.asis.io.provider.BasicUsingPassFileReader;
import cleancode.test.asis.io.provider.LockerPassFileReader;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafePassMachine studyCafePassMachine =
                new StudyCafePassMachine(
                        new BasicUsingPassFileReader(),
                        new LockerPassFileReader()
                );
        studyCafePassMachine.run();
    }
}
