package med.voll.api.domain.records.medico;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.Especialidade;

public record ListaDeMedicosRecord (
    Long id,
    String nome,
    String email,
    String crm,
    Especialidade especialidade
) {

    public ListaDeMedicosRecord (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
