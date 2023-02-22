package Electronic.Start.service.Logic;

import Electronic.Start.entity.Location;
import Electronic.Start.service.ElectronicService;
import Electronic.Start.store.ElectronicStore;
import Electronic.Start.store.Logic.ElectronicStoreLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // lombok이 지원하는 주입방법
public class ElectronicServiceLogic implements ElectronicService {

//    @Autowired // 주입방식 ElectronicStore의 구현체를 주입
//    private ElectronicStore electronicStore;


//    private ElectronicStore electronicStore;
//    // 생성자 주입
//    public ElectronicServiceLogic(ElectronicStore electronicStore){
//        this.electronicStore = electronicStore;
//    }

    private final ElectronicStore electronicStore; // fianl로 지정하면 반드시 한번은 초기화가 되어야한다.

    // 생략부분
//    public ElectronicStoreLogic(ElectronicStore electronicStore){
//        this.electronicStore = electronicStore;
//    }




    @Override
    public String register(Location location) {
        return this.electronicStore.create(location);
    }

    @Override
    public void UpdateLocation(Location location) {
        this.electronicStore.update(location);
    }

    @Override
    public void DeleteLocation(String id) {
        this.electronicStore.delete(id);

    }

    @Override
    public Location findLocation(String id) {
        return this.electronicStore.Search(id);
    }

    @Override
    public List<Location> findLocationAll() {
        return this.electronicStore.SearchAll();
    }
}
