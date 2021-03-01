package rmuti.runnerapp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import rmuti.runnerapp.model.table.SaveRunner;

public interface SaveRunnerRepository extends JpaRepository<SaveRunner,Integer> {
}
