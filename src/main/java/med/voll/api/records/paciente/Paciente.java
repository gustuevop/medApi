package med.voll.api.records.paciente;

import med.voll.api.records.endereco.EnderecoRecord;

public record Paciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        EnderecoRecord enderecoRecord
) {
}
