package med.voll.api.records.paciente;

import med.voll.api.model.paciente.Paciente;

public record ListaDePacientesRecord(
        String nome,
        String email,
        String telefone
) {
    public ListaDePacientesRecord(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }
}
