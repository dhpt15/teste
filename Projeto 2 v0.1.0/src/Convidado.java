public class Convidado extends User {

    public Convidado() {
    }

    public Convidado(int internalID, String civilID, String nome, String phone, String email, String job, Authorisation status) {
        super(internalID, civilID, nome, phone, email, job, status);
    }
}
