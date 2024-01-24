package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaDeConsultasService;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.records.DadosDetalhamentoConsulta;
import med.voll.api.domain.records.consulta.AgendamentoConsultaRecord;
import med.voll.api.domain.records.consulta.DadosCancelamentoConsultaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private AgendaDeConsultasService agenda;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid AgendamentoConsultaRecord agendamentoConsultaRecord) {
        DadosDetalhamentoConsulta dadosConsulta = agenda.agendar(agendamentoConsultaRecord);
        return ResponseEntity.ok(dadosConsulta);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsultaRecord dadosCancelamentoConsultaRecord) {
        agenda.cancelar(dadosCancelamentoConsultaRecord);
        return ResponseEntity.noContent().build();
    }


}


















