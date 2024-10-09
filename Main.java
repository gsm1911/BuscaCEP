import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cep;
        String endereco;
        Scanner leitor = new Scanner(System.in);
        HttpClient cliente = HttpClient.newHttpClient();

        while(true){
            System.out.println("Insira um CEP ou digite sair para encerrar: ");
            cep = leitor.nextLine();

            if(cep.equalsIgnoreCase("sair")){
                break;
            }
            if(cep.length() < 8 || checarDigitos(cep, cep.length())){
                System.out.println("Cep informado inválido.");
            } else {
                endereco = "http://viacep.com.br/ws/" + cep + "/json/";

                HttpFuncoes httpFuncoesClass = new HttpFuncoes();
                String json = httpFuncoesClass.buscaHTTP(endereco);

                GeradorDeArquivos escritor = new GeradorDeArquivos();
                escritor.escreveJson(json);
                escritor.printaJson(json);
            }
        }
    }
    public static boolean checarDigitos(String cep, int n){
        for (int i = 0; i < n; i++) {
            if(!Character.isDigit(cep.charAt(i))){
                System.out.println("CEP contém caracteres invalidos.");
                return true;
            }
        }
        return false;
    }
}