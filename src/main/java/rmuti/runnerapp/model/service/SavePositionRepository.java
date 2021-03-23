package rmuti.runnerapp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import rmuti.runnerapp.model.table.SavePosition;

import java.util.List;

public interface SavePositionRepository extends JpaRepository<SavePosition,Integer> {
    List<SavePosition> findByUserIdAndIdAndDateNow(int UserId,int Id,String DateNow);

    List<SavePosition> findByIdAndUserId(int Id,int UserId);

    List<SavePosition> deleteByIdAndUserId(int id, int userId);

}
