package abstractclass_templatepattern.ex4;

public class SportsCar extends Car {
    @Override
    public void drive() {
        System.out.println("스포츠 모드 주행");
    }

    @Override
    public void afterDriveStart() {
        System.out.println("초고속 주행$");
    }
}
