import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gestor_Acessos {
    private List<Access> Autorizado = new ArrayList<>();
    private List<Access> N_Autorizado = new ArrayList<>();
    private Gestor_Veiculos veiculos;
    private Gestor_Usuarios usuarios;

    public void addAccess(Access a, boolean autorizado){
        if (autorizado){
            Autorizado.add(a);
        }
        else {
            N_Autorizado.add(a);
        }
    }

    public void delAccess(int escolha, boolean autorizado){
        if (autorizado){
            Autorizado.remove(escolha);
        }
        else {
            N_Autorizado.remove(escolha);
        }
    }

    public void delAccess(Veiculo v){
        Iterator<Access> it = Autorizado.iterator();
        while (it.hasNext()){
            Veiculo aux = it.next().getVeiculo();
            if (aux==v){
                it.remove();
            }
        }
        it = N_Autorizado.iterator();
        while (it.hasNext()){
            Veiculo aux = it.next().getVeiculo();
            if (aux==v){
                it.remove();
            }
        }
    }

    public void delAccess(Date min, Date max){
        Iterator<Access> it = Autorizado.iterator();
        while (it.hasNext()){
            Date aux = it.next().getData();
            if (aux.Entre_Datas(min,max)){
                it.remove();
            }
        }
        it = N_Autorizado.iterator();
        while (it.hasNext()){
            Date aux = it.next().getData();
            if (aux.Entre_Datas(min,max)){
                it.remove();
            }
        }
    }

    public boolean Autorizado(Access a){
        Authorisation policy=a.getUser().getStatus();
        if (policy instanceof Auth_Nenhum) return false;
        if (policy instanceof Auth_Total) return true;
        if (policy instanceof Auth_Entre_horas)
            return a.getHora().Entre_Horas(policy.getHoraMin(),policy.getHoraMax());
        if (policy instanceof Auth_Entre_datas){
            if (a.getHora().Entre_Horas(policy.getHoraMin(),policy.getHoraMax()))
                return a.getData().Entre_Datas(((Auth_Entre_datas) policy).getDataMin(),((Auth_Entre_datas) policy).getDataMax());
            return false;
        }
        return false;
    }

    public String listAccess(){
        StringBuilder s= new StringBuilder();
        int count=1;
        s.append("\tAutorizados:\n");
        for (Access a: Autorizado){
            s.append(count);
            s.append(" - ");
            s.append(a.toString());
            s.append('\n');
            count++;
        }
        s.append("\tNão autorizados:\n");
        for (Access a: N_Autorizado){
            s.append(count);
            s.append(" - ");
            s.append(a.toString());
            s.append('\n');
            count++;
        }
        return s.toString();
    }

    public void setGestores(Gestor_Veiculos veiculos, Gestor_Usuarios usuarios){
        this.usuarios=usuarios;
        this.veiculos=veiculos;
    }

    public List<Access> getAutorizado() {
        return Autorizado;
    }

    public void setAutorizado(List<Access> autorizado) {
        Autorizado = autorizado;
    }

    public List<Access> getN_Autorizado() {
        return N_Autorizado;
    }

    public void setN_Autorizado(List<Access> n_Autorizado) {
        N_Autorizado = n_Autorizado;
    }

    public Gestor_Veiculos getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Gestor_Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    public Gestor_Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Gestor_Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
