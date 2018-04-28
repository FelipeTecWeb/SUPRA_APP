package br.com.supra.gestaoescolar;

/**
 * Created by felip on 27/04/2018.
 */

public class CadastroMethods {


     String Nome;
     String Sobrenome;
     String Senha;
     String Email;
     String Telefone;


     public void setNome(String nome){
         this.Nome = nome;
     }
     public String getNome(){
         return this.Nome;
     }
    public void setSobrenome(String sobrenome){
        this.Sobrenome  = sobrenome;
    }
    public String getSobrenome(){
        return this.Sobrenome;
    }
    public void setEmail(String email){
        this.Email = email;
    }
    public String getEmail(){
        return this.Email;
    }
    public void setSenha(String senha){
        this.Senha = senha;
    }
    public String getSenha(){
        return this.Senha;
    }
    public void setTelefone(String telefone){
        this.Telefone = telefone;
    }
    public String getTelefone(){
        return this.Telefone;
    }


}
