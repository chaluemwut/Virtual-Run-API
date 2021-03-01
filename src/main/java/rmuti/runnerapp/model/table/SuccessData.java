package rmuti.runnerapp.model.table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "success_data")
public class SuccessData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "success_id")
    private int successId;
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
