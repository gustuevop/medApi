package med.voll.api.model.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;
import med.voll.api.records.paciente.PacienteRecord;

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

    @Embedded
    private Endereco endereco;

    public Paciente(PacienteRecord record) {
        this.nome = record.nome();
        this.email = record.email();
        this.telefone = record.telefone();
        this.cpf = record.cpf();
        this.endereco = new Endereco(record.endereco());
    }
}
