package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.records.endereco.EnderecoRecord;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(EnderecoRecord record) {
        this.logradouro = record.logradouro();
        this.bairro = record.bairro();
        this.cep = record.cep();
        this.cidade = record.cidade();
        this.uf = record.uf();
        this.numero = record.numero();
        this.complemento = record.complemento();
    }

    public void atualizarDados(Endereco endereco) {
        if (endereco.logradouro != null) {
            this.logradouro = endereco.getLogradouro();
        }
        if (endereco.bairro != null) {
            this.bairro = endereco.getBairro();
        }
        if (endereco.cep != null) {
            this.cep = endereco.getCep();
        }
        if (endereco.cidade != null) {
            this.cidade = endereco.getCidade();
        }
        if (endereco.uf != null) {
            this.uf = endereco.getUf();
        }
        if (endereco.numero != null) {
            this.numero = endereco.getNumero();
        }
        if (endereco.complemento != null) {
            this.complemento = endereco.getComplemento();
        }
    }
}
