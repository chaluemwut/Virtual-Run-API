package rmuti.runnerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rmuti.runnerapp.model.service.TestAllRepository;
import rmuti.runnerapp.model.service.TestUserRunRepository;
import rmuti.runnerapp.model.table.TestAll;
import rmuti.runnerapp.model.table.TestUserRun;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test_run")
public class TestUserRunController {
    @Autowired
    private TestUserRunRepository testUserRunRepository;
    @Autowired
    private TestAllRepository testAllRepository;
    @PostMapping("/save_run")
    public Object saveRun(TestUserRun testUserRun){
        APIResponse res = new APIResponse();
        System.out.println(testUserRun);
        TestUserRun db = testUserRunRepository.findByIdAndUserId(testUserRun.getId(),testUserRun.getUserId());
        System.out.println(db);
        System.out.println("ffff");
        if(db == null){
            testUserRunRepository.save(testUserRun);
            res.setData(testUserRun);
            res.setStatus(1);
        }else {
            res.setStatus(0);
            res.setMessage("Already has user");
            System.out.println("has user");
        }

        return res;
    }
    @PostMapping("/show_run")
    public Object showRun(){
        APIResponse res = new APIResponse();
        List<TestUserRun> dbRun = testUserRunRepository.findAll();
        res.setData(dbRun);
        return  res;
    }
    @PostMapping("/test_show")
    public Object testShow(@RequestParam int userId){
        APIResponse res = new APIResponse();
        List<TestUserRun> testUserRuns = testUserRunRepository.findByUserId(userId);
        List<Integer> value = new ArrayList<Integer>();

        for(var i=0;i< testUserRuns.size();i++){
            var sum = testUserRuns.get(i);
            var aid = sum.getId();
            value.add(aid);
        }
        System.out.println(value);
        List<TestAll> retAllRun = new ArrayList<>();
        for(var i=0;i< value.size();i++) {
            var sum = value.get(i);
            System.out.println(sum);
            List<TestAll> allRuns = testAllRepository.findByid(sum);
            System.out.println(allRuns);
            var aa = allRuns.get(0);
            retAllRun.add(aa);
        }
        res.setData(retAllRun);
        return  res;
    }
}
