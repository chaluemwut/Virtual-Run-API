package rmuti.runnerapp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import rmuti.runnerapp.model.table.TotalData;

import java.util.List;

public interface TotalDataRepository extends JpaRepository<TotalData,Integer> {
    List<TotalData> findByType(String Type);
    List<TotalData> findByUserIdAndId(int userId,int Id);
    List<TotalData> findByUserId(int userId);
}
