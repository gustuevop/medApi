package med.voll.api.domain.paciente;

import med.voll.api.domain.records.paciente.PacienteRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable pageable);

    PacienteRecord findByIdAndAtivoTrue(Long id);
}
