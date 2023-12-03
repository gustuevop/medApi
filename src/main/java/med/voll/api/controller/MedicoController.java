package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.MedicoRepository;
import med.voll.api.model.medico.Medico;
import med.voll.api.records.medico.MedicoRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}