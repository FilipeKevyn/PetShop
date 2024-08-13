package model;

public class Pet {
    private String nome;
    private Especies gato = Especies.GATO;
    private Especies cachorro = Especies.CACHORRO;

    public Pet(String nome, Especies especies){
        this.nome = nome;
        if (!(especies == cachorro)){
            this.cachorro = especies;
        }
        this.gato = especies;
    }

    @Override
    public String toString() {
        return nome;
    }
}
