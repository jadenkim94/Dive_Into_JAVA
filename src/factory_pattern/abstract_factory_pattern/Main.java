package factory_pattern.abstract_factory_pattern;

public class Main {
    public static void main(String args[]){

        Computer pc1 = ComputerFactory.getComputer(new PcFactory("8GB", "1TB", "Intel i7"));
        Computer server1  = ComputerFactory.getComputer(new ServerFactory("64GB", "10TB", "Intel xeon"));

        System.out.println("PC: " + pc1);
        System.out.println("SERVER: " + server1);


    }
}
