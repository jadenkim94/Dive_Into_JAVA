package factory_pattern.factory_pattern;

public abstract class Computer {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    public String toString(){
        return "RAM = "+this.getRAM()+", HDD = " + this.getHDD() + ", CPU = " + this.getCPU();
    }
}
