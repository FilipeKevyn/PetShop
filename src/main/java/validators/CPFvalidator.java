package validators;

import model.Dono;
import model.Loja;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPFvalidator implements Validator<String>{
    private Loja loja = Loja.getInstance();

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

        Pattern pattern = Pattern.compile(cpfPattern);
        Matcher matcher = pattern.matcher(cpf);

        // falta implementar validar se o cpf não é igual a outro da lista
        return matcher.matches() && verificarSeExiste(cpf);
    }
}
