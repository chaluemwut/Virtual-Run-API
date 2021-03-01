package rmuti.runnerapp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import rmuti.runnerapp.model.table.DataUser;

import java.util.List;

public interface DataUserRepository extends JpaRepository<DataUser,Integer> {
    List<DataUser> findAllByType(String type);
    List<DataUser> findByUserIdAndType(int userId,String type);
}
