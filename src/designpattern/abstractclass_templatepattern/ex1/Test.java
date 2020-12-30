package designpattern.abstractclass_templatepattern.ex1;

public class Test {
    public static void main(String args[]){
        Computer computer = new Desktop();
        computer.display();
        computer.turnOn();
    }
}
