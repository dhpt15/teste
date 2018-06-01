import java.util.ArrayList;
import java.util.List;

public class Gestor_Veiculos {
    private List<Veiculo> Veiculos = new ArrayList<>();
    private Gestor_Usuarios usuarios;
    private Gestor_Acessos acessos;

    public void setGestores(Gestor_Usuarios usuarios, Gestor_Acessos acessos){
        this.acessos=acessos;
        this.usuarios=usuarios;
    }

    public void addVeiculo(Veiculo v, User u){
        Veiculos.add(v);
        u.addVeiculo(v);
    }

    public void delVeiculo(User u, int posicao){
        Veiculo aux=u.getVeiculo(posicao);
        Veiculos.remove(aux);
        u.delVeiculo(posicao);
    }

    public void modVeiculo(Veiculo v, int opcao, String alteracao){
        int i;
        for (i=0; i<Veiculos.size(); i++)
            if (this.Veiculos.get(i)==v)
                break;
        switch (opcao){
            case 1:{
                v.setPlaca(alteracao);
                break;
            }
            case 3:{
                v.setMaker(alteracao);
                break;
            }
            case 4:{
                v.setModel(alteracao);
                break;
            }
            case 5:{
                v.setCor(alteracao);
                break;
            }
            case 6:{
                v.setFuel(alteracao);
                break;
            }
        }
    }

    public void modVeiculo(Veiculo v, User u){
        v.getDono().delVeiculo(v);
        v.setDono(u);
        u.addVeiculo(v);
    }

    public void modVeiculo(Veiculo v, Data_matricula data){
        v.setRegisto(data);
    }

    public void modVeiculo(Veiculo v, boolean in_park){
        v.setIn_park(in_park);
    }

    public String listVeiculos(){
        if (this.Veiculos==null){
            return "Não existem veiculos";
        }
        StringBuilder s= new StringBuilder();
        for (int i=0; i<this.Veiculos.size(); i++) {
            s.append("Veiculo ");
            s.append(String.valueOf(i + 1));
            s.append(": ");
            s.append(this.Veiculos.get(i).toString());
            s.append('\n');
        }
        return s.toString();
    }

    public String listVeiculos_simples(){
        if (this.Veiculos==null){
            return "Não existem veiculos";
        }
        StringBuilder s= new StringBuilder();
        for (int i=0; i<this.Veiculos.size(); i++) {
            s.append("Veiculo ");
            s.append(String.valueOf(i + 1));
            s.append(": ");
            s.append(this.Veiculos.get(i).dados());
            s.append('\n');
        }
        return s.toString();
    }

    public Veiculo getVeiculo(int posicao){
        return Veiculos.get(posicao);
    }

    public List<Veiculo> getVeiculos() {
        return Veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        Veiculos = veiculos;
    }

    public Gestor_Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Gestor_Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Gestor_Acessos getAcessos() {
        return acessos;
    }

    public void setAcessos(Gestor_Acessos acessos) {
        this.acessos = acessos;
    }
}
