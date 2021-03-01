package rmuti.runnerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rmuti.runnerapp.model.service.DataUserRepository;
import rmuti.runnerapp.model.table.DataUser;

import java.util.List;

@RestController
@RequestMapping("/data_user")
public class DataUserController {
    @Autowired
    private DataUserRepository dataUserRepository;
    @PostMapping("/save")
    public Object save(DataUser dataUser){
        APIResponse res = new APIResponse();
        dataUserRepository.save(dataUser);
        res.setData(dataUser);
        return res;
    }
    @PostMapping("/load")
    public Object load(){
        APIResponse res = new APIResponse();
        List<DataUser> db = dataUserRepository.findAll();
        res.setData(db);
        return res;
    }
    @PostMapping("/test_load")
    public Object testLoad(@RequestParam String type){
        List<DataUser> dataUserList = dataUserRepository.findAllByType(type);
        return dataUserList;
    }
    @PostMapping("/get_data")
    public Object getData(@RequestParam int userId,@RequestParam String type){
        List<DataUser> dataUsers = dataUserRepository.findByUserIdAndType(userId,type);
        return dataUsers;
    }

}
