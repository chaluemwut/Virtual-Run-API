package rmuti.runnerapp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import rmuti.runnerapp.model.table.SavePosition;

import java.util.List;

public interface SavePositionRepository extends JpaRepository<SavePosition,Integer> {
    List<SavePosition> findByUserIdAndId(int UserId,int Id);
}
