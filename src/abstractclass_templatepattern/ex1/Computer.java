package abstractclass_templatepattern.ex1;

public abstract class Computer {

    // abstract method 는 하위 클래스에 delegation
    public abstract void display();
    public abstract void typing();

    public void turnOn(){
        System.out.println("전원을 켠다");
    }

    public void turnOff(){
        System.out.println("전원을 끈다");
    }


}
