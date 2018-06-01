public class Data_matricula extends Date {
    public Data_matricula(int mes, int ano) {
        super(1, mes, ano);
    }

    public String toString(){
        return (String.valueOf(this.mes) + '/' + String.valueOf(this.ano));
    }

    public boolean Entre_Datas (Date min, Date max){
        if ((min.getAno() == this.ano) && (min.getAno() == max.getAno())){
            return (min.getMes() <= this.mes) && (min.getMes() <= max.getMes());
        }
        else {
            if (min.getAno()<this.ano &&this.ano <max.getAno()){
                return true;
            }
            else {
                if (min.getAno()==this.ano &&this.ano <max.getAno()){
                    return min.getMes() <= this.mes;
                }
                else {
                    if (min.getAno()<this.ano &&this.ano ==max.getAno()){
                        return this.mes <= max.getMes();
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
            if(this.mes>=1 && this.mes<=12)
                return "true";
            return "Mes Invalido";
        }
        return "Ano invalido";
    }
}
