package rmuti.runnerapp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import rmuti.runnerapp.model.table.SuccessData;

import java.util.List;

public interface SuccessDataRepository extends JpaRepository<SuccessData,Integer> {
    List<SuccessData> findByType(String Type);
    List<SuccessData> findByUserIdAndSuccessId(int userId,int successId);
    List<SuccessData> findByUserId(int userId);
}
