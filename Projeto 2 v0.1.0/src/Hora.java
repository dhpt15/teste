public class Hora {
    private int hora;
    private int minuto;

    public Hora(int hora) {
        this.hora = hora;
        this.minuto = 0;
    }

    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public String valida(){
        if (this.hora>=0&&this.hora<24){
            if (this.minuto>=0&&this.minuto<60){
                return "true";
            }
            return "Minuto invalido";
        }
        return "Hora invalida";
    }

    public boolean Entre_Horas(Hora min, Hora max){
        if (min.getHora()<this.hora&&this.hora<max.getHora())
            return true;
        if (min.getHora()==this.hora&&this.hora==max.getHora()){
            return min.getMinuto()<=this.minuto&&this.minuto<max.getMinuto();
        }
        if (min.getHora()==this.hora&&this.hora<max.getHora()){
            return min.getMinuto()<=this.minuto;
        }
        if (min.getHora()<this.hora&&this.hora==max.getHora()){
            return this.minuto<=max.getMinuto();
        }
        return false;
    }

    public String toString() {
        return (String.valueOf(this.hora) + ':' + String.valueOf(this.minuto));
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
