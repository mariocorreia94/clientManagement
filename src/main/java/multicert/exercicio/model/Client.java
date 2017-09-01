package multicert.exercicio.model;

public class Client {

    private int iduser;
    private String name;
    private String nif;
    private String adress;
    private String phone;

    public Client() {
    }

    public Client(int iduser, String name, String nif, String adress, String phone) {
        this.iduser = iduser;
        this.name = name;
        this.nif = nif;
        this.adress = adress;
        this.phone = phone;
    }

    public Client(String name, String nif, String adress, String phone) {
        this.name = name;
        this.nif = nif;
        this.adress = adress;
        this.phone = phone;
    }


    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", nif=" + nif +
                ", adress='" + adress + '\'' +
                ", phone=" + phone +
                '}';
    }
}
