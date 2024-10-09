public class CEP {
    private String cep;
    private String logradouro;
    private String bairro;

    @Override
    public String toString() {
        return "CEP{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
