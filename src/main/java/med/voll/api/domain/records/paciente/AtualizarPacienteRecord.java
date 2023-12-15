package med.voll.api.domain.records.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AtualizarPacienteRecord(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String telefone
) {
}
