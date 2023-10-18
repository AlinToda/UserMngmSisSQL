package com.itfactory;

public class User {

    private int id;
    private String nume;
    private String prenume;
    private String email;
    private int varsta;

    public User(int id, String nume, String prenume, String email, int varsta) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.varsta = varsta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", " +
                "nume=" + nume + ", " +
                "prenume=" + prenume + ",  " +
                "varsta=" + varsta + ", " +
                "email=" + email + "]";
    }
}
