package med.voll.api.domain.records.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.consulta.Consulta;

import java.time.LocalDateTime;

public record AgendamentoConsultaRecord (
        Long id,
        @NotNull
        Long idPaciente,
        Long idMedico,
        @NotNull
        @Future
        LocalDateTime data
){
}
