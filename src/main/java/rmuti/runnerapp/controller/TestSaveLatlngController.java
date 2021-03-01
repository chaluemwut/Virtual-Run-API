package rmuti.runnerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmuti.runnerapp.model.service.TestSaveLatlngRepository;
import rmuti.runnerapp.model.table.TestSaveLatlng;

import java.util.List;

@RestController
@RequestMapping("/test_save_latlng")
public class TestSaveLatlngController {
    @Autowired
    private TestSaveLatlngRepository testSaveLatlngRepository;
    @PostMapping("/save")
    public Object save(TestSaveLatlng testSaveLatlng){
        APIResponse res = new APIResponse();
        testSaveLatlngRepository.save(testSaveLatlng);
        res.setData(testSaveLatlng);
        return res;
    }
    @PostMapping("/load")
    public Object load(){
        APIResponse res = new APIResponse();
        List<TestSaveLatlng> dbFun = testSaveLatlngRepository.findAll();
        res.setData(dbFun);
        return res;
    }
}
