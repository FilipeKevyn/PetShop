package controller;

import model.Dono;
import model.Loja;
import window.TableTestWindow;

import java.util.List;

public class CadastroController {
    private Loja loja = new Loja();
    private Dono dono = new Dono();
    private TableTestWindow tableTestWindow;

    public CadastroController(TableTestWindow tableTestWindow) {
        this.tableTestWindow = tableTestWindow;
    }

    public Dono addCadastro(String nome, String cpf) {
        dono.setNome(nome);
        dono.setCpf(cpf);
        loja.getProprietarios().add(dono);
        adicionaNatabela();

        dono = new Dono();
        return dono;
    }

    public List<String> addPet(String nomePet) {
        dono.getPets().add(nomePet);

        return dono.getPets();
    }

    public void adicionaNatabela() {
        if (!dono.getPets().isEmpty()) {
            tableTestWindow.adicionarLinha(dono.getNome(), dono.getCpf(), dono.getPets().get(0));
        }
    }

    public Dono getDono() {
        return dono;
    }
}