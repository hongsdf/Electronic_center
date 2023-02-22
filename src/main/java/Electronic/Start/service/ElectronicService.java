package Electronic.Start.service;

import Electronic.Start.entity.Location;

import java.util.List;

public interface ElectronicService {

    String register(Location location); // 등록
    void UpdateLocation(Location location); // 장소 업데이트
    void DeleteLocation(String id); // 장소 삭제
    Location findLocation(String id); // 장소 1개 찾기
    List<Location> findLocationAll(); // 모든 장소 찾기

}
