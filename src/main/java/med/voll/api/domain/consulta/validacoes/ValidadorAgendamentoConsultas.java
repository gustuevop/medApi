package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.records.consulta.AgendamentoConsultaRecord;

public interface ValidadorAgendamentoConsultas {
    void validar(AgendamentoConsultaRecord dados);
}
