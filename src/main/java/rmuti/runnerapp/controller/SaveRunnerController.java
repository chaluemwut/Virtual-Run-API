package rmuti.runnerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmuti.runnerapp.model.service.SaveRunnerRepository;
import rmuti.runnerapp.model.table.SaveRunner;

import java.util.List;

@RestController
@RequestMapping("/save_runner")
public class SaveRunnerController {
    @Autowired
    private SaveRunnerRepository saveRunnerRepository;
    @PostMapping("/save")
    public Object save(SaveRunner saveRunner){
        APIResponse res = new APIResponse();
        saveRunnerRepository.save(saveRunner);
        res.setData(saveRunner);
        return res;
    }
    @PostMapping("/load")
    public Object load(){
        APIResponse res = new APIResponse();
        List<SaveRunner> db = saveRunnerRepository.findAll();
        res.setData(db);
        return res;
    }
}
