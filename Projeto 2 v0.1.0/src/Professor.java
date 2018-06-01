public class Professor extends User {

    public Professor() {
    }

    public Professor(int internalID, String civilID, String nome, String phone, String email, String job, Authorisation status) {
        super(internalID, civilID, nome, phone, email, job, status);
    }
}
