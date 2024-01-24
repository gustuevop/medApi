package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoConsultas;
import med.voll.api.domain.exceptions.EspecialidadeNullaException;
import med.voll.api.domain.exceptions.MedicoInexistenteException;
import med.voll.api.domain.exceptions.PacienteInexistenteException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.records.DadosDetalhamentoConsulta;
import med.voll.api.domain.records.consulta.AgendamentoConsultaRecord;
import med.voll.api.domain.records.consulta.DadosCancelamentoConsultaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultasService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidadorAgendamentoConsultas> validadores;

    public DadosDetalhamentoConsulta agendar(AgendamentoConsultaRecord dados) {
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new MedicoInexistenteException("O médico informado não existe no banco de dados. Faça o cadastro do médico primeiramente.");
        }
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new PacienteInexistenteException("O paciente informado não existe no banco de dados. Faça o cadastro do médico primeiramente.");
        }

        validadores.forEach(validador -> validador.validar(dados));

        Medico medico = escolherMedico(dados);
        Paciente paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        Consulta consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(AgendamentoConsultaRecord dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new EspecialidadeNullaException("É necessário informar a especialidade quando o médico não for escolhido.");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());

    }

    public void cancelar(DadosCancelamentoConsultaRecord dadosCancelamentoConsultaRecord) {

    }
}
















