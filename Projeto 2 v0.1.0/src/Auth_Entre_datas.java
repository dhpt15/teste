public class Auth_Entre_datas extends Authorisation {
    private Date dataMin;
    private Date dataMax;

    public Auth_Entre_datas(Hora horaMin, Hora horaMax, Date dataMin, Date dataMax) {
        this.horaMin = horaMin;
        this.horaMax = horaMax;
        this.dataMin = dataMin;
        this.dataMax = dataMax;
    }

    public String toString(){
        if (dataMin == dataMax)
            return (super.toString() + ", no dia " + dataMin.toString());
        else
            return (super.toString() + ", entre os dias " + dataMin.toString() + " e " + dataMax.toString());
    }

    public Date getDataMin() {
        return dataMin;
    }

    public void setDataMin(Date dataMin) {
        this.dataMin = dataMin;
    }

    public Date getDataMax() {
        return dataMax;
    }

    public void setDataMax(Date dataMax) {
        this.dataMax = dataMax;
    }
}
