package factory_pattern.factory_pattern;

public class Main {
    public static void main(String args[]){

        Computer pc1 = ComputerFactory.getComputer("PC", "8GB", "1TB", "Intel i7");
        Computer server1 = ComputerFactory.getComputer("server", "64GB", "10TB", "Intel xeon");

        System.out.println("PC: " + pc1);
        System.out.println("Server: " + server1);


    }
}
