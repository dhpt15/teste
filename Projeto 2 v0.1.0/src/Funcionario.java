public class Funcionario extends User {

    public Funcionario() {
    }

    public Funcionario(int internalID, String civilID, String nome, String phone, String email, String job, Authorisation status) {
        super(internalID, civilID, nome, phone, email, job, status);
    }
}
