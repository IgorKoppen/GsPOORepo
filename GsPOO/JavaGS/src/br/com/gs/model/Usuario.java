package br.com.gs.model;

import br.com.gs.util.CriptografiaUtils;

import java.sql.Date;

public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String email;
    private Date
            data = new Date(System.currentTimeMillis());
    public Usuario() {
    }

    public Usuario( String nome, String senha, String email){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getData(){
        return data;
    }
    public Date setData(Date data){
        return this.data = data;
    }

    public void setSenha(String senha){
        try {
            this.senha = CriptografiaUtils.criptografar(senha);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
