package Electronic.Start.store;

import Electronic.Start.entity.Location;

import java.util.List;

public interface ElectronicStore {
    String create(Location location); // 등록
    void update(Location location); // 업데이트
    void delete(String id); // 삭제

    Location Search(String id); // 1개 조회
    List<Location> SearchAll(); // 모두 조회
}
