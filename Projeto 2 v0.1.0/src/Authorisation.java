abstract public class Authorisation {
    protected Hora horaMin;
    protected Hora horaMax;

    public String toString(){
        return ("entre as " + horaMin.toString() + " e as " + horaMax.toString());
    }

    public Hora getHoraMin() {
        return horaMin;
    }

    public void setHoraMin(Hora horaMin) {
        this.horaMin = horaMin;
    }

    public Hora getHoraMax() {
        return horaMax;
    }

    public void setHoraMax(Hora horaMax) {
        this.horaMax = horaMax;
    }
}
