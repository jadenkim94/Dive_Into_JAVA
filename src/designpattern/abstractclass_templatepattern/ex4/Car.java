package designpattern.abstractclass_templatepattern.ex4;

public abstract class Car {

    public  void turnOn(){
        System.out.println("시동을 켠다");
    };

    public abstract void drive();

    public void turnOff(){
        System.out.println("시동을 끈다.");
    }

    public void afterDriveStart(){
    }

    public void afterTurnOff(){

    }

    // 템플릿 메서드
    public final void driving(){
        turnOn();
        drive();
        afterDriveStart();
        turnOff();
        afterTurnOff();
    }

}
