package Electronic.Start.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Location {
    private String id; // 랜덤하게 id부여
    private String City; // 도시
    private String GU; // 구

    public Location(){
        this.id = UUID.randomUUID().toString(); // id가 생성시 마다 랜덤하게 부여됨
    }

    public Location(String City,String GU){
        this(); // id 호출
        this.City = City;
        this.GU = GU;
    }


    public static Location ex(){
        return new Location("서울","강남");
    }

    public static void main(String[] args) {
        Location location = new Location("부산","소래포구");
        System.out.println(new Gson().toJson(location));
    }
}
