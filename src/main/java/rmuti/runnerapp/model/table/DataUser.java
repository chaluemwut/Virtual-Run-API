package rmuti.runnerapp.model.table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "data_user")
public class DataUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int did;
    @Column(name = "user_id")
    private int userId;
    @Column
    private String km;
    @Column
    private String time;
    @Column(name = "type")
    private String type;
}
