package med.voll.api.records.medico;

import med.voll.api.model.medico.Especialidade;
import med.voll.api.records.endereco.Endereco;

public record Medico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco
) {
}
