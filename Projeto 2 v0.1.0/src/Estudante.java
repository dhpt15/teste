public class Estudante extends User {

    public Estudante() {
    }

    public Estudante(int internalID, String civilID, String nome, String phone, String email, String job, Authorisation status) {
        super(internalID, civilID, nome, phone, email, job, status);
    }
}
