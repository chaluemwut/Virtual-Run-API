package rmuti.runnerapp.model.table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "test_all")
public class TestAll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name_all")
    private String nameAll;
    @Column
    private String distance;
    @Column
    private String type;
    @Column(name = "date_start")
    private String dateStart;
    @Column(name = "date_end")
    private String dateEnd;
    @Column(name = "img_all")
    private String imgAll;

    //เปลี่ยน string เป็น date
}
