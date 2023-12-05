package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.MedicoRepository;
import med.voll.api.model.medico.Medico;
import med.voll.api.records.medico.ListaDeMedicosRecord;
import med.voll.api.records.medico.MedicoRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
     public void cadastrar(@RequestBody @Valid MedicoRecord medicoRecord) {
        repository.save(new Medico(medicoRecord));
     }
     @GetMapping
     public Page<ListaDeMedicosRecord> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAll(pageable).map(ListaDeMedicosRecord::new);
     }

}