package br.com.supra.gestaoescolar;


public class Turma {
    private String sala;
    private String inicia;
    private String encerra;
    private String professor;
    private String materia;
    private Integer lockStatus;

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

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }
}
