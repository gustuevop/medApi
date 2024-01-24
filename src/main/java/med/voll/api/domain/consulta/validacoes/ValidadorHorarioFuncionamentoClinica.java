package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.records.consulta.AgendamentoConsultaRecord;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsultas {
    public void validar(AgendamentoConsultaRecord dados) {
        LocalDateTime data = dados.data();
        boolean domingo = data.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean antesDaHora = data.getHour() < 7;
        boolean depoisDaHora = data.getHour() > 18;

        if (domingo || antesDaHora || depoisDaHora) {
            throw new RuntimeException("Consulta fora do horário de funcionamento da clínica.");
        }
    }
}
