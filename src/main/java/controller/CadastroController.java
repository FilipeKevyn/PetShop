package controller;

import model.Dono;
import model.Loja;
import model.Pet;

import java.util.List;

public class CadastroController {
    private Loja loja;
    private Dono dono = new Dono();
    private static CadastroController instance;
    private CadastroController() {
        loja = new Loja();
    }
    public static CadastroController getInstance() {
        if (instance == null){
            instance = new CadastroController();
        }
        return instance;
    }

    public Dono addCadastro(String nome, String cpf) {
        dono.setNome(nome);
        dono.setCpf(cpf);
        loja.getCadastrados().add(dono);

        dono = new Dono();
        return dono;
    }

    public List<Pet> addPet(String nome_pet, String especies) {
        Pet pet = new Pet(nome_pet, especies);
        dono.getPets().add(pet);

        return dono.getPets();
    }

    public Dono getDono() {
        return dono;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}