package rmuti.runnerapp.model.table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "save_position")
public class SavePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;
    @Column(name = "user_id")
    private int userId;
    @Column
    private int id;
    @Column
    private double lat;
    @Column
    private double lng;
    @Column(name = "date_now")
    private String dateNow;
}
