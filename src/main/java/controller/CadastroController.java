package controller;

import model.Dono;
import model.Loja;
import window.TableTestWindow;


public class CadastroController {
    private Loja loja = new Loja();
    private Dono dono = new Dono();
    private TableTestWindow tableTestWindow;

    public CadastroController(TableTestWindow tableTestWindow) {
        this.tableTestWindow = tableTestWindow;
    }

    public Dono addCadastro(String nome, String cpf) {
        dono = new Dono(nome, cpf); // Cria um novo dono com os dados fornecidos
        loja.getProprietarios().add(dono);

        return dono;
    }

    public String addPet(String nomePet) {
        dono.getPets().add(nomePet);

        // Atualiza a tabela com o novo dono e pet
        tableTestWindow.adicionarLinha(dono.getNome(), dono.getCpf(), nomePet);

        return nomePet;
    }
}