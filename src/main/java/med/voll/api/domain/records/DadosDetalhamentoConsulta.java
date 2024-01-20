package med.voll.api.domain.records;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta (
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data
){
}
