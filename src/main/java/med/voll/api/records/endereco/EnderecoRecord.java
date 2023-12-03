package med.voll.api.records.endereco;

public record EnderecoRecord(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero
) {
}
