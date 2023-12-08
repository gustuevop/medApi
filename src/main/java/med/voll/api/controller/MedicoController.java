package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.MedicoRepository;
import med.voll.api.model.medico.Medico;
import med.voll.api.records.medico.AtualizarMedicoRecord;
import med.voll.api.records.medico.ListaDeMedicosRecord;
import med.voll.api.records.medico.CadastroMedicoRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
     public void cadastrar(@RequestBody @Valid CadastroMedicoRecord cadastroMedicoRecord) {
        repository.save(new Medico(cadastroMedicoRecord));
     }

     @GetMapping
     public Page<ListaDeMedicosRecord> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(ListaDeMedicosRecord::new);
     }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarMedicoRecord record) {
        Medico med = repository.getReferenceById(record.id());
        med.atualizarDados(record);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        medico.excluir();
    }
}