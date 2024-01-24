package med.voll.api.domain.records.consulta;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.consulta.MotivoCancelamento;

public record DadosCancelamentoConsultaRecord(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamento motivo
) {
}
