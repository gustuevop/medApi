package med.voll.api.records.medico;

import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.Especialidade;

public record ListaDeMedicosRecord (
    String nome,
    String email,
    String crm,
    Especialidade especialidade
) {

    public ListaDeMedicosRecord (Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
