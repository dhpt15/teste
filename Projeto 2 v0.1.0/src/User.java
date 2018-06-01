abstract public class User {
    protected int internalID;
    protected String civilID;
    protected String nome;
    protected String phone;
    protected String email;
    protected String job;
    protected Veiculo[] veiculos;
    protected Authorisation status;

    public User() {
    }

    public User(int internalID, String civilID, String nome, String phone, String email, String job, Authorisation status) {
        this.internalID = internalID;
        this.civilID = civilID;
        this.nome = nome;
        this.phone = phone;
        this.email = email;
        this.job = job;
        this.status = status;
    }

    public void addVeiculo(Veiculo v){
        if (this.veiculos==null){
            this.veiculos=new Veiculo[1];
            this.veiculos[0]=v;
            return;
        }
        int n=this.veiculos.length;
        Veiculo[] aux = this.veiculos;
        this.veiculos = new Veiculo[n + 1];
        System.arraycopy(aux, 0, this.veiculos, 0, n);
        this.veiculos[n] = v;
    }

    public void delVeiculo(int posicao){
        int n=this.veiculos.length-1;
        if (n==0) {
            this.veiculos=null;
            return;
        }
        Veiculo[] aux = this.veiculos;
        this.veiculos = new Veiculo[n];
        System.arraycopy(aux, 0, this.veiculos, 0, posicao);
        System.arraycopy(aux, posicao + 1, this.veiculos, posicao, n - posicao);
    }

    public void delVeiculo(Veiculo v){
        int posicao;
        for (posicao=0;posicao<this.veiculos.length;posicao++)
            if (veiculos[posicao]==v)
                break;
        delVeiculo(posicao);
    }

    public String listVeiculos(){
        if (this.veiculos==null){
            return "O usuario não possui veiculos";
        }
        StringBuilder s= new StringBuilder();
        for (int i=0; i<this.veiculos.length; i++) {
            s.append("Veiculo ");
            s.append(String.valueOf(i + 1));
            s.append(": ");
            s.append(this.veiculos[i].toString());
            s.append('\n');
        }
        return s.toString();
    }

    public String toString() {
        return "User{" +
                "internalID=" + internalID +
                ", civilID='" + civilID + '\'' +
                ", nome='" + nome + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", veiculos=" + veiculos[0].toString() +
                ", status=" + status.toString() +
                '}';
    }

    public  String dados(){
        return "User{" + "internalID=" + internalID + " nome='" + nome + '}';
    }

    public Veiculo getVeiculo(int posicao) {
        return this.veiculos[posicao];
    }

    public int getInternalID() {
        return internalID;
    }

    public void setInternalID(int internalID) {
        this.internalID = internalID;
    }

    public String getCivilID() {
        return civilID;
    }

    public void setCivilID(String civilID) {
        this.civilID = civilID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }

    public Authorisation getStatus() {
        return status;
    }

    public void setStatus(Authorisation status) {
        this.status = status;
    }
}
