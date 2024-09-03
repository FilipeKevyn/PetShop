package validators;

public class NomeValidator implements Validator<String>{
    @Override
    public boolean validar(String nome) {
        return !nome.isEmpty() && nome.length() >= 3;
    }
}
