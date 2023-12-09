package med.voll.api.model.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;
import med.voll.api.records.paciente.AtualizarPacienteRecord;
import med.voll.api.records.paciente.CadastroPacienteRecord;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(CadastroPacienteRecord record) {
        this.ativo = true;
        this.nome = record.nome();
        this.email = record.email();
        this.telefone = record.telefone();
        this.cpf = record.cpf();
        this.endereco = new Endereco(record.endereco());
    }

    public void atualizarDados(AtualizarPacienteRecord record) {
        if (record.nome() != null) {
            this.nome = record.nome();
        }
        if (record.email() != null) {
            this.email = record.email();
        }
        if (record.telefone() != null) {
            this.telefone = record.telefone();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
