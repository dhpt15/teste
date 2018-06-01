import java.util.ArrayList;
import java.util.List;

public class Gestor_Usuarios {
    private List<User> Usuarios = new ArrayList<>();
    private Gestor_Veiculos veiculos;
    private Gestor_Acessos acessos;
    private Authorisation[] padrao= new Authorisation[3];

    public Gestor_Usuarios(){
        padrao[0]= new Auth_Nenhum();
        padrao[1]=new Auth_Total();
        padrao[2]=new Auth_Entre_horas(new Hora(8),new Hora(20));
    }

    public void setGestores(Gestor_Veiculos veiculos, Gestor_Acessos acessos){
        this.acessos=acessos;
        this.veiculos=veiculos;
    }

    public void addUser(User u){
        Usuarios.add(u);
    }

    public String listUsers_simples(){
        StringBuilder s= new StringBuilder();
        int count=1;
        for (User u: Usuarios){
            s.append(String.valueOf(count));
            s.append(u.dados());
            s.append('\n');
            count++;
        }
        return s.toString();
    }

    public String listUsers(){
        StringBuilder s= new StringBuilder();
        int count=1;
        for (User u: Usuarios){
            s.append(String.valueOf(count));
            s.append(u.toString());
            s.append('\n');
            count++;
        }
        return s.toString();
    }

    public void delUser(User u){
        Usuarios.remove(u);
    }

    public void modUser(User u, int opcao, String alteracao){
        switch (opcao){
            case 1:{
                u.setInternalID(Integer.valueOf(alteracao));
                break;
            }
            case 2:{
                u.setCivilID(alteracao);
                break;
            }
            case 3:{
                u.setNome(alteracao);
                break;
            }
            case 4:{
                u.setPhone(alteracao);
                break;
            }
            case 5:{
                u.setEmail(alteracao);
                break;
            }
            case 6:{
                u.setJob(alteracao);
                break;
            }
        }
    }

    public void modUser(User u, Authorisation a){
        u.setStatus(a);
    }

    public User getUser(int posicao){
        return Usuarios.get(posicao);
    }

    public List<User> getUsuarios() {
        return Usuarios;
    }

    public Authorisation getPadrao(int i){
        return this.padrao[i];
    }

    public void setUsuarios(List<User> usuarios) {
        Usuarios = usuarios;
    }

    public Gestor_Veiculos getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Gestor_Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    public Gestor_Acessos getAcessos() {
        return acessos;
    }

    public void setAcessos(Gestor_Acessos acessos) {
        this.acessos = acessos;
    }

    public Authorisation[] getPadrao() {
        return padrao;
    }

    public void setPadrao(Authorisation[] padrao) {
        this.padrao = padrao;
    }
}
