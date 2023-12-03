package med.voll.api.controller;

import med.voll.api.model.medico.MedicoRepository;
import med.voll.api.model.medico.Medico;
import med.voll.api.records.medico.MedicoRecord;
import org.springframework.beans.factory.annotation.Autowired;
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
     public void cadastrar(@RequestBody MedicoRecord medicoRecord) {
        repository.save(new Medico(medicoRecord));
     }

}
