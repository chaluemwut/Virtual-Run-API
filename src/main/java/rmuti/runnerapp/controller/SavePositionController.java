package rmuti.runnerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rmuti.runnerapp.model.service.SavePositionRepository;
import rmuti.runnerapp.model.table.SavePosition;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/save_position")
public class SavePositionController {
    @Autowired
    private SavePositionRepository savePositionRepository;
    @PostMapping("/save")
    public Object save(SavePosition savePosition){
        APIResponse res = new APIResponse();
        savePositionRepository.save(savePosition);
        res.setData(savePosition);
        return res;
    }
    @PostMapping("/load")
    public Object load(){
        APIResponse res = new APIResponse();
        List<SavePosition> db = savePositionRepository.findAll();
        res.setData(db);
        return res;
    }
    @PostMapping("/show")
    public Object show(@RequestParam int userId,@RequestParam int id,@RequestParam String dateNow){
        APIResponse res = new APIResponse();
        List<SavePosition> savePositions = savePositionRepository.findByUserIdAndIdAndDateNow(userId, id,dateNow);
        res.setData(savePositions);
        return res;
    }
    @PostMapping("/remove")
    public Object remove(@RequestParam int id,@RequestParam int userId){
        APIResponse res = new APIResponse();
        System.out.println(id);
        System.out.println(userId);
        List<SavePosition> savePosition = savePositionRepository.findByIdAndUserId(id, userId) ;
        System.out.println(savePosition);
        List<Integer> value = new ArrayList<>();
        for(var i=0;i<savePosition.size();i++){
            var sum = savePosition.get(i);
            var sid = sum.getSid();
            try{
            savePositionRepository.deleteById(sid);
                res.setStatus(0);
                res.setMessage("Remove LatLng success!");

            }catch (Exception e){
                e.printStackTrace();
                res.setStatus(1);
            }
        }
        System.out.println(value);


        return res;
    }
}
