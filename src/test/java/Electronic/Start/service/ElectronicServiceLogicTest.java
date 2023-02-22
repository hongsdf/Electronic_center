package Electronic.Start.service;

import Electronic.Start.entity.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest // 테스트
public class ElectronicServiceLogicTest {

    // 테스트는 @Autowired 밖에 되지 않는다.
    @Autowired
    private ElectronicService electronicService;

    private Location CITY;
    private Location CITY2;

    @BeforeEach // 단위테스트 실행전 호출되는 메서드 : 용도는 테스트를 위한 기본적인 세팅
    public void startUp(){
        this.CITY = new Location("Seoul1","은평");
        this.CITY2 = new Location("Seoul1","남대문");
        this.electronicService.register(CITY);
        this.electronicService.register(CITY2);


    }


    @Test // 단위 테스트
    public void createTest(){
        Location sample =  Location.ex();
        // 결과를 알고 테스트를 진행 {서울,강남} : JUnit5 기반 테스트진행
        assertThat(this.electronicService.register(sample)).isEqualTo(sample.getId()); // id가 같다면 true 테스트 통과
        assertThat(this.electronicService.findLocationAll().size()).isEqualTo(3); // 기대값과 다른값
        this.electronicService.DeleteLocation(sample.getId());
    }

    /*
        테스트결과는
        1. 예상값과 같은 경우
        2. 예상값과 다른 경우
        3. 에러 (해당 의존성을 주입할수 없는 경우 - NPE) @Autowired 설정
     */

    @Test
    public void find(){
        assertThat(this.electronicService.findLocation(CITY2.getId())).isNotNull();
        assertThat(this.electronicService.findLocation(CITY.getId()).getCity()).isEqualTo(CITY2.getCity());
    }

    @AfterEach // 테스트 완료 후, 실행되는 메서드
    public void cleanUp(){
        this.electronicService.DeleteLocation(CITY.getId());
        this.electronicService.DeleteLocation(CITY2.getId());

    }

}
