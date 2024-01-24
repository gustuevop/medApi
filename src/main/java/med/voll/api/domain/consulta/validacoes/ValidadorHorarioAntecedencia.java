package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.records.consulta.AgendamentoConsultaRecord;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsultas {

    public void validar(AgendamentoConsultaRecord dados) {
        LocalDateTime dataConsulta = dados.data();
        LocalDateTime dataAtual = LocalDateTime.now();
        Long diferencaEmMinutos = Duration.between(dataAtual, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new RuntimeException("Consulta deve ser agendada com antecedência mínima de 30 minutos.");
        }
    }
}
