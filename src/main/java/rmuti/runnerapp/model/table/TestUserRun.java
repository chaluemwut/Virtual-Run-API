package rmuti.runnerapp.model.table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "test_run")
public class TestUserRun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rid;
    @Column(name = "user_id")
    private int userId;
    @Column
    private int id;
}
