import java.util.Scanner;

public class Menu {
    final Gestor_Acessos acessos;
    Gestor_Usuarios usuarios;
    Gestor_Veiculos veiculos;
    Scanner read;

    public Menu(){
        acessos = new Gestor_Acessos();
        usuarios = new Gestor_Usuarios();
        veiculos = new Gestor_Veiculos();
        read = new Scanner(System.in);
        this.acessos.setGestores(this.veiculos, this.usuarios);
        this.usuarios.setGestores(this.veiculos, this.acessos);
        this.veiculos.setGestores(this.usuarios, this.acessos);
    } //v

    public void principal(){
        int opcao;
        do{
            System.out.println("1-Adicionar Acesso");
            System.out.println("2-Gerir Usuarios");
            System.out.println("3-Gerir Veiculos");
            System.out.println("4-Gerir Acessos");
            System.out.println("0-Sair");
            opcao=read.nextInt();

            switch (opcao){
                case 1:{
                    criarAccess();
                    break;
                }
                case 2: {
                    manageUsers();
                    break;
                }
                case 3:{
                    manageVeiculos();
                    break;
                }
                case 4:{
                    manageAcessos();
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Opção invalida");
                }
            }
        }while (true);
    }

    public void manageUsers(){
        int opcao;
        do{
            System.out.println("1-Criar usuario");
            System.out.println("2-Eliminar usuario");
            System.out.println("3-Editar usuario");
            System.out.println("4-Listar usuarios");
            System.out.println("0-Sair");
            opcao=read.nextInt();
            switch (opcao){
                case 1:{
                    criarUser();
                    break;
                }
                case 2: {
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    listarUser();
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Opção invalida");
                }
            }
        }while (true);
    }

    public void manageVeiculos(){
        int opcao;
        do{
            System.out.println("1-Criar veiculo");
            System.out.println("2-Eliminar veiculo");
            System.out.println("3-Editar veiculo");
            System.out.println("4-Listar veiculos");
            System.out.println("0-Sair");
            opcao=read.nextInt();
            switch (opcao){
                case 1:{
                    criarVeiculo();
                    break;
                }
                case 2: {
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Opção invalida");
                }
            }
        }while (true);
    }

    public void manageAcessos(){
        int opcao;
        do{
            System.out.println("1-Criar acesso");
            System.out.println("2-Eliminar acesso");
            System.out.println("3-Eliminar acessos de um veiculo especifico");
            System.out.println("4-Eliminar acessos entre duas datas");
            System.out.println("5-Listar acessos de um veiculo especifico");
            System.out.println("6-Listar acessos de um usuario especifico");
            System.out.println("7-Listar acessos entre duas datas");
            System.out.println("0-Sair");
            opcao=read.nextInt();
            switch (opcao){
                case 1:{
                    criarAccess();
                    break;
                }
                case 2:
                case 3:
                case 4:{
                    eliminarAcesso(opcao);
                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    break;
                }
                case 7:{
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Opção invalida");
                }
            }
        }while (true);
    }

    public void criarUser(){
        int opcao;
        User user=null;
        System.out.println("\tTipo de usuario:");
        System.out.println("1-Estudante");
        System.out.println("2-Professor");
        System.out.println("3-Funcionário");
        System.out.println("4-Convidado");
        System.out.println("0-Sair");
        System.out.print("\tOpção:");
        opcao=read.nextInt();
        do {
            switch (opcao){
                case 1: {
                    user=new Estudante();
                    user.setStatus(usuarios.getPadrao(2));
                    break;
                }
                case 2:{
                    user=new Professor();
                    user.setStatus(usuarios.getPadrao(1));
                    break;
                }
                case 3:{
                    user=new Funcionario();
                    user.setStatus(usuarios.getPadrao(1));
                    break;
                }
                case 4:{
                    user= new Convidado();
                    user.setStatus(usuarios.getPadrao(0));
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("opção Invalida");
                }
            }
        }while (opcao!=1&&opcao!=2&&opcao!=3&&opcao!=4);
        System.out.println("\tIntroduza:");
        System.out.print("ID interno:");
        user.setInternalID(read.nextInt());
        System.out.print("Id Civil:");
        user.setCivilID(read.nextLine());
        System.out.print("Nome:");
        user.setNome(read.nextLine());
        System.out.print("Numero de telemovel:");
        user.setPhone(read.nextLine());
        System.out.print("Email:");
        user.setEmail(read.nextLine());
        System.out.print("Job:");
        user.setJob(read.nextLine());
        usuarios.addUser(user);
        System.out.println("Usuario criado\n");
        System.out.println("Pretende adicionar um veiculo a este utilizador?");
        do{
            System.out.println("\t1-Sim\t2-Não");
            opcao=read.nextInt();
            if (opcao==1){
                criarVeiculo(user);
            }
            if (opcao==2)
                return;
            System.out.println("Opção Invalida");
        }while (opcao!=1&&opcao!=2);
        System.out.println();
    } //v

    public void criarVeiculo() {
        System.out.println("A qual usuario quer adicionar um veiculo");
        listarUser_simples();
        System.out.println("opção:");
        User u=usuarios.getUser(read.nextInt()-1);
        Veiculo v = new Veiculo();
        data_in(v.getRegisto());
        v.setPlaca(read.nextLine());
        v.setMaker(read.nextLine());
        v.setModel(read.nextLine());
        v.setCor(read.nextLine());
        v.setFuel(read.nextLine());
        v.setIn_park(false);
        veiculos.addVeiculo(v,u);
        System.out.println("Veiculo Criado com Sucesso");
    }

    public void criarVeiculo(User u){
        Veiculo v = new Veiculo();
        data_in(v.getRegisto());
        v.setPlaca(read.nextLine());
        v.setMaker(read.nextLine());
        v.setModel(read.nextLine());
        v.setCor(read.nextLine());
        v.setFuel(read.nextLine());
        v.setIn_park(false);

        veiculos.addVeiculo(v,u);
    }

    public void criarAccess(){
        Access novo= new Access();
        int opcao=0;
        veiculos.listVeiculos_simples();
        System.out.println("Insira numero do veiculo:");
        novo.setVeiculo(veiculos.getVeiculo(read.nextInt()-1));
        data_in(novo.getData());
        hora_in(novo.getHora());
        while (opcao!=1&&opcao!=2){
            System.out.println("\t1-IN\t2-OUT\nInsira a opcao: ");
            opcao=read.nextInt();
            switch (opcao){
                case 1:{
                    novo.setIn_park(true);
                    break;
                }
                case 2:{
                    novo.setIn_park(false);
                    break;
                }
                default:
                    System.out.println("Opcao invalida");
            }
        }
        acessos.addAccess(novo, acessos.Autorizado(novo));
    }

    public void listarUser_simples(){
        System.out.println( usuarios.listUsers_simples());
    }

    public void listarUser(){
        System.out.println( usuarios.listUsers());
    }

    public void listarAcess(){
        System.out.println(acessos.listAccess());
    }

    public void eliminarAcesso(int opcao){
        switch (opcao){
            case 1:{
                System.out.println("------Acessos------");
                listarAcess();
                System.out.print("Insira o numero do Acesso que quer eliminar:");
                opcao=read.nextInt();
                while (opcao<1&&opcao>=(acessos.getAutorizado().size()+acessos.getN_Autorizado().size()-1)){
                    System.out.println("Opção invalida");
                    opcao=read.nextInt();
                }
                boolean autorizado=true;
                if (opcao>acessos.getAutorizado().size()){
                    opcao-=acessos.getAutorizado().size();
                    autorizado=false;
                }
                acessos.delAccess(opcao, autorizado);
                break;
            }
            case 2:{
                veiculos.listVeiculos_simples();
                System.out.print("Insira o numero do veiculo do qual quer apagar os acessos:");
                opcao=read.nextInt();
                while (opcao<1&&opcao>=veiculos.getVeiculos().size()){
                    System.out.println("Opção invalida");
                    opcao=read.nextInt();
                }
                acessos.delAccess(veiculos.getVeiculo(opcao));
                break;
            }
            case 3:{
                Date min=new Date();
                Date max=new Date();
                System.out.println("\tData minima:");
                data_in(min);
                System.out.println("\tData maxima:");
                data_in(max);
                acessos.delAccess(min,max);
                break;
            }
        }
        return;
    }

    public void data_in(Date data){
        do{
            if (!(data instanceof Data_matricula)){
                System.out.print("Insira a data (dd/mm/aaaa): ");
                data.setDia(read.nextInt());
            }
            else {
                System.out.print("Insira a data de matricula (mm/aaaa): ");
            }
            data.setMes(read.nextInt());
            data.setAno(read.nextInt());
            System.out.println();
        }while (!data_valida(data));
    }

    public void hora_in(Hora hora){
        do {
            System.out.println("Insira a hora (hh:mm)");
            hora.setHora(read.nextInt());
            hora.setMinuto(read.nextInt());
            System.out.println();
        }while (!hora_valida(hora));
    }

    public boolean data_valida(Date d){
        String s=d.valida();
        if (Boolean.valueOf(s)){
            return true;
        }
        else {
            System.out.println(s);
            return false;
        }
    }

    public boolean hora_valida(Hora h){
        String s=h.valida();
        if (Boolean.valueOf(s)){
            return true;
        }
        else {
            System.out.println(s);
            return false;
        }
    }
}
