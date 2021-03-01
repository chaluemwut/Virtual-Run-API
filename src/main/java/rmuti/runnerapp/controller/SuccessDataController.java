package rmuti.runnerapp.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rmuti.runnerapp.model.service.SuccessDataRepository;
import rmuti.runnerapp.model.service.UserProfileRepository;
import rmuti.runnerapp.model.table.SuccessData;
import rmuti.runnerapp.model.table.UserProfile;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/success_data")
public class SuccessDataController {
    @Autowired
    private SuccessDataRepository successDataRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @PostMapping("/save")
    public Object save(SuccessData successData){
        APIResponse res = new APIResponse();
        successDataRepository.save(successData);
        res.setData(successData);
        return res;
    }
    @PostMapping("/load")
    public Object load(){
        APIResponse res = new APIResponse();
        List<SuccessData> db = successDataRepository.findAll();
        res.setData(db);
        return res;
    }
    @PostMapping("/show")
    public Object show(@RequestParam int userId, int successId){
        List<SuccessData> db = successDataRepository.findByUserIdAndSuccessId(userId, successId);
        return db;
    }
    @PostMapping("/show_data")
    public Object showData(@RequestParam int userId){
        List<SuccessData> db = successDataRepository.findByUserId(userId);
        return db;
    }
    @PostMapping("/show_type")
    public Object showType(@RequestParam String type){
        List<SuccessData> db = successDataRepository.findByType(type);
        return db;
    }
    @PostMapping("/show_id")
    public Object showById(@RequestParam String type){
        APIResponse res = new APIResponse();

        List<SuccessData> successDataList = successDataRepository.findByType(type);
        List<Integer> value = new ArrayList<>();
        for(int i=0;i<successDataList.size();i++){
            var sum = successDataList.get(i);
            var user = sum.getUserId();
            value.add(user);
        }
        List<String> _list = new ArrayList<>();
        for(int a=0;a<successDataList.size();a++){
            var aaa = successDataList.get(a);
            var ss = aaa.getSuccessId();
            var ui = aaa.getUserId();
            var id = aaa.getId();
            var km = aaa.getKm();
            var time = aaa.getTime();
            var ty = aaa.getType();
            var kmm = "km: "+km;
            var tim = "time:"+time;
            _list.add(km);
            _list.add(time);
            System.out.println("aaa"+_list);
        }
        System.out.println(value);
        List<UserProfile> retUser = new ArrayList<>();
        List _data = new ArrayList();
        for (int i=0;i<value.size();i++){
            var sum = value.get(i);
            List<UserProfile> userProfileList = userProfileRepository.findByUserId(sum);
            var aa = userProfileList.get(0);
            retUser.add(aa);
            System.out.println(retUser);
            for(int b=0;b<retUser.size();b++){
                var bbb = retUser.get(b);
                var usi = bbb.getUserId();
                var usn = bbb.getUserName();
                var pas = bbb.getPassWord();
                var au = bbb.getAu();
                var na = bbb.getName();
                var te = bbb.getTel();
                var img = bbb.getImgProfile();
                var useri = "userId: "+usi;
                var nam = "name: "+na;
                var im = "imgProfile: "+img;
                System.out.println(useri);
                _data.add(usi);
                _data.add(na);
                _data.add(img);
                System.out.println("bbb"+_data);
            }
        }

        List list = new ArrayList();
        list.addAll(successDataList);
        list.addAll(retUser);
        System.out.println(_list);
        System.out.println(_data);
        JSONArray jsonArray = new JSONArray(list);
        System.out.println(jsonArray);
        res.setData(successDataList);
        res.setGetData(retUser);
        return res;
    }
    @PostMapping("/update")
    public Object upDate(SuccessData successData){
        try {
            successData = successDataRepository.save(successData);

        }catch (Exception e){

        }
        return successData;
    }
}
