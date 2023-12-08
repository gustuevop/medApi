package med.voll.api.records.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endereco.Endereco;

public record AtualizarMedicoRecord(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        Endereco endereco
) {
}
