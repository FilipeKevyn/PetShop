package validators;

import controller.AgendaController;
import controller.CadastroController;
import model.Dono;
import model.Loja;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPFvalidator implements Validator<String>{
    private Loja loja = CadastroController.getInstance().getLoja();

    public boolean verificarSeExiste(String cpf){
        for (Dono dono : loja.getCadastrados()){
            if (dono.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean validar(String cpf) {
        String cpfPattern = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

        // Use the Pattern and Matcher classes to perform the match
        Pattern pattern = Pattern.compile(cpfPattern);
        Matcher matcher = pattern.matcher(cpf);

        return matcher.matches();
    }
}
