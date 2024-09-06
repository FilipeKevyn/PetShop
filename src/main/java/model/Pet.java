package model;

public class Pet {
    private String nome;
    private String especies;
    private Dono dono;

    public Pet(String nome, String especie){
        this.nome = nome;
        this.especies = especie;
    }
    public String getNome() {
        return nome;
    }

    public String getEspecie(){
        return especies;
    }
    @Override
    public String toString() {
        return nome;
    }
}
