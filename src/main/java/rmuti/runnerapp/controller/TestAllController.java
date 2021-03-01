package rmuti.runnerapp.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rmuti.runnerapp.model.service.TestAllRepository;
import rmuti.runnerapp.model.table.TestAll;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/test_all")
public class TestAllController {
    @Autowired
    private TestAllRepository testAllRepository;
    @PostMapping("/save")
    public Object save(TestAll testAll){
        APIResponse res = new APIResponse();
        testAllRepository.save(testAll);
        res.setData(testAll);
        return res;
    }
    @PostMapping("/load")
    public Object load(){
        APIResponse res = new APIResponse();
        List<TestAll> db = testAllRepository.findAll();
        res.setData(db);
        return res;
    }
    @PostMapping("/show")
    public Object show(@RequestParam String type){
        List<TestAll> _list = testAllRepository.findAllByType(type);
        return _list;
    }
    @PostMapping("/show_id")
    public Object showID(@RequestParam int id){
        List<TestAll> db = testAllRepository.findByid(id);
        return db;
    }
    @PostMapping("/update")
    public Object update(TestAll testAll, @RequestParam(value = "fileImg",required = false)MultipartFile fileImg){
        APIResponse res = new APIResponse();
        Random random = new Random();
        try{
            if(fileImg != null){
                char a = (char) (random.nextInt(26)+'a');
                testAll.setImgAll(String.valueOf(a)+".png");
                File fileToSave = new File("E://virtualrun//imgdata//allrun//"+testAll.getImgAll());
                fileImg.transferTo(fileToSave);
                testAll = testAllRepository.save(testAll);
                res.setData(testAll);
                res.setStatus(1);
            }
        }catch (Exception e){
            res.setMessage("err");
            res.setStatus(0);
        }
        return res;
    }
    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getResource (@RequestParam String imgAll) throws Exception{
        try {
            InputStream in = new FileInputStream("E://virtualrun//imgdata//allrun//"+imgAll);
            var inImg =  IOUtils.toByteArray(in);
            in.close();
            return inImg;
        }catch (Exception e){
            return null;
        }
    }
    @PostMapping("/remove")
    public Object remove(@RequestParam int id){
        APIResponse res = new APIResponse();
        TestAll testAll = testAllRepository.findById(id).get();
        System.out.println(testAll);
        try{

            File fileToDelete = new File("E://virtualrun//imgdata//allrun//"+testAll.getImgAll());
            Files.delete(Path.of(String.valueOf(fileToDelete)));
            testAllRepository.deleteById(id);
            res.setStatus(0);
            res.setMessage("Remove product success!");

        }catch (Exception e){
            e.printStackTrace();
            res.setStatus(1);
        }

        return res;
    }

}
