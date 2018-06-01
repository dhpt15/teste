public class Date {
    protected int dia;
    protected int mes;
    protected int ano;

    public Date() {
    }

    public Date(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString() {
        return (String.valueOf(this.dia) + '/' + String.valueOf(this.mes) + '/' + String.valueOf(this.ano));
    }

    public boolean Entre_Datas (Date min, Date max){
        if ((min.getAno() == this.ano) && (min.getAno() == max.getAno())){
            if ((min.getMes() == this.mes) && (min.getMes() == max.getMes())){
                return (min.getDia() <= this.dia) && (this.dia <= max.getDia());
            }
            else {
                if (min.getMes()<this.mes&&this.mes<max.getMes()) {
                    return true;
                }
                else {
                    if (min.getMes()==this.mes&&this.mes<max.getMes()){
                        return min.getDia() <= this.dia;
                    }
                    else {
                        if (min.getMes()<this.mes&&this.mes==max.getMes()){
                            return this.dia <= max.getDia();
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
        }
        else {
            if (min.getAno()<this.ano &&this.ano <max.getAno()){
                return true;
            }
            else {
                if (min.getAno()==this.ano &&this.ano <max.getAno()){
                    if (min.getMes()<this.mes){
                        return true;
                    }
                    else {
                        if (min.getMes()==this.mes){
                            return min.getDia() <= this.dia;
                        }
                        else {
                            return false;
                        }
                    }
                }
                else {
                    if (min.getAno()<this.ano &&this.ano ==max.getAno()){
                        if (this.mes<max.getMes()){
                            return true;
                        }
                        else {
                            if (this.mes==max.getMes()){
                                return this.dia <= max.getDia();
                            }
                            else {
                                return false;
                            }
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
        }
    }

    public String valida(){						//verificação se a data é valida
        if(this.ano>=0){
            if(this.mes>=1 && this.mes<=12){
                if((this.dia>=1 && this.dia<=31) && (this.mes==1 || this.mes==3 || this.mes==5 || this.mes==7 || this.mes==8 || this.mes==10 || this.mes==12))
                    return "true";
                if((this.dia>=1 && this.dia<=30) && (this.mes==4 || this.mes==6 || this.mes==9 || this.mes==11))
                    return "true";
                if((this.dia>=1 && this.dia<=28) && (this.mes==2))
                    return "true";
                if(this.dia==29 && this.mes==2 && (this.ano%400==0 ||(this.ano%4==0 && this.ano%100!=0)))
                    return "true";
                return "Dia invalido";
            }
            return "Mes Invalido";
        }
        return "Ano invalido";
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
