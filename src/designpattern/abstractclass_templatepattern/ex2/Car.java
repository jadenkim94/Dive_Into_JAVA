package designpattern.abstractclass_templatepattern.ex2;

public abstract class Car {
    public abstract void drive();
    public abstract void stop();

    public void startCar(){
        System.out.println("시동을 킨다.");
    }
    public void turnOff(){
        System.out.println("시동을 끈다");
    }

    // 템플릿 메서드 - 시나리오를 정해놓음
    final public void run(){
        startCar();
        drive();
        stop();
        turnOff();
    }
}
