package management.client.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Client {

    private int id;

    @NotNull(message = "Nome é obrigatório")
    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "[a-z-A-Z]*", message = "O nome contem caracteres inválidos")
    private String name;

    @Pattern(regexp="(^$|[0-9]{9})", message = "NIF tem que ter 9 numeros")
    private String nif;

    private String adress;

    @Pattern(regexp="(^$|[0-9]{9})", message = "Numero de telefone tem que ter 9 numeros")
    private String phone;

    public Client() {
    }

    public Client(int id, String name, String nif, String adress, String phone) {
        this.id = id;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
