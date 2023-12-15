package med.voll.api.domain.records.paciente;

import med.voll.api.domain.paciente.Paciente;

public record ListaDePacientesRecord(
        Long id,
        String nome,
        String email,
        String telefone
) {
    public ListaDePacientesRecord(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }
}
