package validators;

public interface Validator<T> {
    boolean validar(T data);
}
