package rmuti.runnerapp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import rmuti.runnerapp.model.table.TestUserRun;

import java.util.List;

public interface TestUserRunRepository extends JpaRepository<TestUserRun,Integer> {
    List<TestUserRun> findByUserId(int userId);
    TestUserRun findByIdAndUserId(int Id,int UserId);
}
