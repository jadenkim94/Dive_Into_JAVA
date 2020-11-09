package abstractclass_templatepattern.ex4;

public class EcoCar extends Car {
    @Override
    public void drive() {
        System.out.println("에코모드 주행");
    }

    @Override
    public void afterTurnOff() {
        System.out.println("전기충전 시작");
    }
}
