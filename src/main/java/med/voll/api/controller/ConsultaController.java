package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.records.DadosDetalhamentoConsulta;
import med.voll.api.domain.records.consulta.AgendamentoConsultaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid AgendamentoConsultaRecord agendamentoConsultaRecord) {
        System.out.println(agendamentoConsultaRecord);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }


}


















