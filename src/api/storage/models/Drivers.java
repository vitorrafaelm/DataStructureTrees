package api.storage.models;

public class Drivers {

    String name;
    String CPF;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "name='" + name + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
