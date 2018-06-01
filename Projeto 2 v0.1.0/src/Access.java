public class Access {
    private Hora hora;
    private Date data;
    private Veiculo veiculo;
    private boolean in_park;

    public Access() {
    }

    public Access(Hora hora, Date data, Veiculo veiculo, boolean in_park) {
        this.hora = hora;
        this.data = data;
        this.veiculo = veiculo;
        this.in_park = in_park;
    }

    public String toString() {
        return "Access{" +
                "hora=" + hora +
                ", data=" + data +
                ", veiculo=" + veiculo +
                ", in_park=" + in_park +
                '}';
    }

    public User getUser(){
        return this.veiculo.getDono();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public boolean isIn_park() {
        return in_park;
    }

    public void setIn_park(boolean in_park) {
        this.in_park = in_park;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
}
