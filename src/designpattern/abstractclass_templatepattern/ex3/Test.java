package designpattern.abstractclass_templatepattern.ex3;

public class Test {
    public static void main(String[] args) {

        Player p1 = new Player();
        p1.play(3);

        AdvancedLevel advancedLevel = new AdvancedLevel();
        p1.upgradeLevel(advancedLevel);

        p1.play(3);

    }
}
