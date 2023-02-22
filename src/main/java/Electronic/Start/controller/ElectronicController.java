package Electronic.Start.controller;

import Electronic.Start.entity.Location;
import Electronic.Start.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // json형태로 데이터를 주고 받는다.
public class ElectronicController {
    // 응답 결과를 JSON형태로 반환


    private ElectronicService electronicService;

    public ElectronicController(ElectronicService electronicService){
        this.electronicService = electronicService;
    }

    @PostMapping("/locations")
    public String register(@RequestBody Location location){
        return this.electronicService.register(location);
    }

    @GetMapping("/locations/{id}")
    public Location findbyId(@PathVariable String id){
        return this.electronicService.findLocation(id);
    }

    @GetMapping("/locations")
    public List<Location> findByAll(){
        return this.electronicService.findLocationAll();
    }

    @PutMapping("/locations/{id}")
    public void UpDate(@PathVariable String id,@RequestBody Location location ){ // 바꿔야 되는 내용을 json으로 전달
        this.electronicService.UpdateLocation(location);
    }

    @DeleteMapping("/locations/{id}")
    public void Delete(@PathVariable String id){
        this.electronicService.DeleteLocation(id);

    }


}
