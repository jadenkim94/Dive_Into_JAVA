package abstractclass_templatepattern.ex3;

public class SuperLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("매우 빨리 달립니다");
    }

    @Override
    public void jump() {
        System.out.println("매우 높이 점프 합니다");
    }

    @Override
    public void turn() {
        System.out.println("turn 합니다");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("**초급자 레벨**");
    }
}
