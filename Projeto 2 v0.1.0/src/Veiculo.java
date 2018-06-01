public class Veiculo {
    private String placa;
    private Data_matricula registo;
    private String maker;
    private String model;
    private String cor;
    private String fuel;
    private User dono;
    private boolean in_park;

    public Veiculo() {
    }

    public Veiculo(String placa, Data_matricula registo, String maker, String model, String cor, String fuel, User dono, boolean in_park) {
        this.placa = placa;
        this.registo = registo;
        this.maker = maker;
        this.model = model;
        this.cor = cor;
        this.fuel = fuel;
        this.dono = dono;
        this.in_park = in_park;
    }

    public String toString() {
        String s="";
        s +="Veiculo\n";
        s +="placa='" + placa + '\n';
        s+=", registo=" + registo.toString();
        s+=", maker='" + maker + '\n';
        s+=", model='" + model + '\n';
        s+=", cor='" + cor + '\n';
        s+=", fuel='" + fuel + '\n';
        s+=", dono=" + dono.getNome();
        s+=", in_park=" + in_park;
        s+='}';
        return s;
    }

    public String dados(){
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", dono=" + dono.getNome() +
                ", in_park=" + in_park +
                '}';
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public User getDono() {
        return dono;
    }

    public void setDono(User dono) {
        this.dono = dono;
    }

    public boolean isIn_park() {
        return in_park;
    }

    public void setIn_park(boolean in_park) {
        this.in_park = in_park;
    }

    public Data_matricula getRegisto() {
        return registo;
    }

    public void setRegisto(Data_matricula registo) {
        this.registo = registo;
    }
}
