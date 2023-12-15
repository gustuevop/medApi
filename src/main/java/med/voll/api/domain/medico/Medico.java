package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.records.medico.AtualizarMedicoRecord;
import med.voll.api.domain.records.medico.CadastroMedicoRecord;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(CadastroMedicoRecord record) {
        this.ativo = true;
        this.nome = record.nome();
        this.email = record.email();
        this.telefone = record.telefone();
        this.crm = record.crm();
        this.especialidade = record.especialidade();
        this.endereco = new Endereco(record.endereco());
    }

    public void atualizarDados(AtualizarMedicoRecord record) {
        if (record.nome() != null) {
            this.nome = record.nome();
        }
        if (record.email() != null) {
            this.email = record.email();
        }
        if (record.telefone() != null) {
            this.telefone = record.telefone();
        }
        if (record.endereco() != null) {
            this.endereco.atualizarDados(record.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

























