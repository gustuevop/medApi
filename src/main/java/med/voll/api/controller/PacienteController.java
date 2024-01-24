package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.records.paciente.AtualizarPacienteRecord;
import med.voll.api.domain.records.paciente.ListaDePacientesRecord;
import med.voll.api.domain.records.paciente.CadastroPacienteRecord;
import med.voll.api.domain.records.paciente.PacienteRecord;
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
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroPacienteRecord cadastroPacienteRecord, UriComponentsBuilder uriBuilder) {
        Paciente paciente = new Paciente(cadastroPacienteRecord);
        repository.save(paciente);

        PacienteRecord pacienteRecord = new PacienteRecord(paciente);
        URI uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(pacienteRecord);
    }

    @GetMapping
    public ResponseEntity<Page<ListaDePacientesRecord>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        Page<ListaDePacientesRecord> response =  repository.findAllByAtivoTrue(pageable).map(ListaDePacientesRecord::new);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarPacienteRecord atualizarPacienteRecord) {
        Paciente pa = repository.getReferenceById(atualizarPacienteRecord.id());
        pa.atualizarDados(atualizarPacienteRecord);
        return ResponseEntity.ok(new PacienteRecord(pa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Paciente pa = repository.getReferenceById(id);
        pa.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Paciente paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacienteRecord(paciente));
    }
}












