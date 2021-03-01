package rmuti.runnerapp.model.table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "total_data")
public class TotalData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    @Column(name = "user_id")
    private int userId;
    @Column
    private int id;
    @Column
    private String km;
    @Column
    private String time;
    @Column
    private String type;
}
