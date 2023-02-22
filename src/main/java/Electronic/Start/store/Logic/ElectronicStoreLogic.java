package Electronic.Start.store.Logic;

import Electronic.Start.entity.Location;
import Electronic.Start.store.ElectronicStore;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository // 빈객체로 등록 (STORE 부분)
public class ElectronicStoreLogic implements ElectronicStore {

    // Location정보들을 저장하기위한 컬렉션
    private Map<String,Location> LocationMap;

    public ElectronicStoreLogic() {
        this.LocationMap = new HashMap<>();
    }


    @Override
    public String create(Location location) {
        this.LocationMap.put(location.getId(), location);
        return location.getId();
    }

    @Override
    public void update(Location location) {
        this.LocationMap.put(location.getId(), location);
    }

    @Override
    public void delete(String id) {
        this.LocationMap.remove(id);
    }

    @Override
    public Location Search(String id) {
        return this.LocationMap.get(id);
    }

    @Override
    public List<Location> SearchAll() {
        // 스트림 사용
        return this.LocationMap.values().stream().collect(Collectors.toList());

    }
}
