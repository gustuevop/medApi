package med.voll.api.domain.records.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.Endereco;

public record AtualizarMedicoRecord(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        Endereco endereco
) {
}
