package algorithm.algo_study_2021.july.fourth_week;

import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class Number9 {

    static class Coordinate{
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean conditionCheck(){
            if(this.x < -5 || this.x > 5 || this.y < -5 || this.y > 5) return false;
            return true;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Path{
        int beforeX;
        int beforeY;
        int nowX;
        int nowY;

        public Path(int beforeX, int beforeY, int nowX, int nowY) {
            this.beforeX = beforeX;
            this.beforeY = beforeY;
            this.nowX = nowX;
            this.nowY = nowY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return beforeX == path.beforeX && beforeY == path.beforeY && nowX == path.nowX && nowY == path.nowY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(beforeX, beforeY, nowX, nowY);
        }

        @Override
        public String toString() {
            return "{" +
                    "beforeX=" + beforeX +
                    ", beforeY=" + beforeY +
                    ", nowX=" + nowX +
                    ", nowY=" + nowY +
                    '}';
        }
    }


    public static void main(String[] args) {

        System.out.println(solution("LRLRL"));


    }

    public static int solution(String dirs) {
        Coordinate start = new Coordinate(0,0);
        Stack<Coordinate> coordinateStack = new Stack<>();
        coordinateStack.add(start);

        HashSet<Path> paths = new HashSet<>();


        for(int i = 0; i < dirs.length(); i++){
            switch (dirs.charAt(i)){
                case 'U':
                    Coordinate before = coordinateStack.peek();
                    Coordinate now = new Coordinate(before.x-1, before.y);
                    if(now.conditionCheck()){
                        paths.add(new Path(before.x, before.y, now.x, now.y));
                        paths.add(new Path(now.x, now.y, before.x, before.y));
                        coordinateStack.add(now);
                    }
                    break;
                case 'D':
                    before = coordinateStack.peek();
                    now = new Coordinate(before.x+1, before.y);
                    if(now.conditionCheck()){
                        paths.add(new Path(before.x, before.y, now.x, now.y));
                        paths.add(new Path(now.x, now.y, before.x, before.y));
                        coordinateStack.add(now);
                    }
                    break;
                case 'R':
                    before = coordinateStack.peek();
                    now = new Coordinate(before.x, before.y+1);
                    if(now.conditionCheck()){
                        paths.add(new Path(before.x, before.y, now.x, now.y));
                        paths.add(new Path(now.x, now.y, before.x, before.y));
                        coordinateStack.add(now);
                    }

                    break;
                case 'L':
                    before = coordinateStack.peek();
                    now = new Coordinate(before.x, before.y-1);
                    if(now.conditionCheck()){
                        paths.add(new Path(before.x, before.y, now.x, now.y));
                        paths.add(new Path(now.x, now.y, before.x, before.y));
                        coordinateStack.add(now);
                    }
                    break;
            }
        }

        return paths.size()/2;
    }



}
