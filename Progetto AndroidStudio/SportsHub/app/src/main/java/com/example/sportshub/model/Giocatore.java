package com.example.sportshub.model;

public class Giocatore {
    String email;
    String nome;
    String cognome;
    String password;
    String indirizzo;
    String citta;
    String numeroTelefono;

    public Giocatore(String email, String nome, String cognome, String password, String indirizzo, String citta, String numeroTelefono) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
