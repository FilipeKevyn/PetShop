package model;

public class Pet {
    private String nome;
    private Especie especies;
    private Dono dono;

    public Pet(String nome, String especie){
        this.nome = nome;
        if (especie.equals("Cachorro")){
            this.especies = Especie.CACHORRO;
        } else {
            this.especies = Especie.GATO;
        }
    }
    public String getNome() {
        return nome;
    }

    public Especie getEspecie(){
        return especies;
    }
    @Override
    public String toString() {
        return nome;
    }
}
