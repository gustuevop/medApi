package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.records.medico.AtualizarMedicoRecord;
import med.voll.api.domain.records.medico.ListaDeMedicosRecord;
import med.voll.api.domain.records.medico.CadastroMedicoRecord;
import med.voll.api.domain.records.medico.MedicoRecord;
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
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
     public ResponseEntity cadastrar(@RequestBody @Valid CadastroMedicoRecord cadastroMedicoRecord, UriComponentsBuilder uriBuilder) {
        Medico medico = new Medico(cadastroMedicoRecord);
        repository.save(medico);

        MedicoRecord medicoRecord = new MedicoRecord(medico);
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(medicoRecord);
     }

     @GetMapping
     public ResponseEntity<Page<ListaDeMedicosRecord>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
         Page<ListaDeMedicosRecord> response =  repository.findAllByAtivoTrue(pageable).map(ListaDeMedicosRecord::new);
         return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarMedicoRecord atualizarMedicoRecord) {
        Medico med = repository.getReferenceById(atualizarMedicoRecord.id());
        med.atualizarDados(atualizarMedicoRecord);
        return ResponseEntity.ok(new MedicoRecord(med));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new MedicoRecord(medico));
    }
}