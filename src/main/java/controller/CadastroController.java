package controller;

import model.Dono;
import model.Loja;
import model.Pet;
import window.TableTestWindow;

import java.util.List;

public class CadastroController {
    private Loja loja = Loja.getInstance();
    private Dono dono = new Dono();
    private TableTestWindow tableTestWindow;

    public CadastroController() {
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
}