import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivos {
    public void escreveJson(String json) throws IOException {
        FileWriter escritor = new FileWriter("cep.json");
        escritor.write(json);
        escritor.close();
    }
    public void printaJson(String json){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        CEP cepResultado = gson.fromJson(json, CEP.class);
        System.out.println(cepResultado);
    }
}
