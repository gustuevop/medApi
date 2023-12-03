package med.voll.api.records.medico;

import med.voll.api.model.medico.Especialidade;
import med.voll.api.records.endereco.EnderecoRecord;

public record MedicoRecord(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        EnderecoRecord endereco
) {
}
