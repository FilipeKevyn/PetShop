package principal;

import model.Loja;

import java.io.*;

public class SerializationUtil {

    public static void serializarLoja(Loja loja, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(loja);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Loja desserializarLoja(String filename) {
        Loja loja = null;
        File data = new File(filename);
        if (data.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                loja = (Loja) ois.readObject();
                System.out.println("Loja desserializada com sucesso.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return loja;
    }
}