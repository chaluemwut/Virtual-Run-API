package rmuti.runnerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rmuti.runnerapp.model.service.TotalDataRepository;
import rmuti.runnerapp.model.table.TotalData;

import java.util.List;

@RestController
@RequestMapping("/total_data")
public class TotalDataController {
    @Autowired
    private TotalDataRepository totalDataRepository;
    @PostMapping("/save")
    public Object save(TotalData totalData){
        APIResponse res = new APIResponse();
        totalDataRepository.save(totalData);
        res.setData(totalData);
        return res;
    }
    @PostMapping("/load")
    public Object load(){
        APIResponse res = new APIResponse();
        List<TotalData> db = totalDataRepository.findAll();
        res.setData(db);
        return res;
    }
    @PostMapping("/show")
    public Object show(@RequestParam int userId,int id){
        List<TotalData> db = totalDataRepository.findByUserIdAndId(userId, id);
        return db;
    }
    @PostMapping("/show_data")
    public Object showData(@RequestParam int userId){
        List<TotalData> db = totalDataRepository.findByUserId(userId);
        return db;
    }
    @PostMapping("/show_type")
    public Object showType(@RequestParam String type){
        List<TotalData> db = totalDataRepository.findByType(type);
        return db;
    }
    @PostMapping("/update")
    public Object upDate(TotalData totalData){
        try {
            totalData = totalDataRepository.save(totalData);

        }catch (Exception e){

        }
        return totalData;
    }

}
