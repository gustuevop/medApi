package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.paciente.Paciente;
import med.voll.api.model.paciente.PacienteRepository;
import med.voll.api.records.paciente.ListaDePacientesRecord;
import med.voll.api.records.paciente.PacienteRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteRecord pacienteRecord) {
        repository.save(new Paciente(pacienteRecord));
    }

    @GetMapping
    public Page<ListaDePacientesRecord> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAll(pageable).map(ListaDePacientesRecord::new);
    }
}