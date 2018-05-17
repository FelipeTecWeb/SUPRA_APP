package br.com.supra.gestaoescolar;


public class Turma {
    String sala;
    String inicia;
    String encerra;
    String professor;
    String materia;
    String lockStatus;

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getInicia() {
        return inicia;
    }

    public void setInicia(String inicia) {
        this.inicia = inicia;
    }

    public String getEncerra() {
        return encerra;
    }

    public void setEncerra(String encerra) {
        this.encerra = encerra;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getLockStatus() {
        return String.valueOf( lockStatus );
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus;
    }
}
