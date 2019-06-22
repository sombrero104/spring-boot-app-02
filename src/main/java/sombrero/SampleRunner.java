package sombrero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    /*@Value("${sombrero.name}")
    private String name;

    @Value("${sombrero.age}")
    private int age;*/

    @Autowired
    SombreroProperties sombreroProperties;

    /**
     * 위에서 사용한 @Value 방식보다는 type safe 함. (오타를 방지할 수 있음.)
     */

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========================");
        /*System.out.println("# name: " + name);
        System.out.println("# age: " + age);*/
        System.out.println("# name: " + sombreroProperties.getName());
        System.out.println("# age: " + sombreroProperties.getAge());
        System.out.println("# age: " + sombreroProperties.getSessionTimeout());
        System.out.println("========================");
        /**
         * 결과는..
         * Application으로 실행 시 name: Just do it.
         * ApplicationTest로 실행 시 name: hide
         */
    }

    /**
     * 프로퍼티 우선 순위
     * 1. 유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties
     * 2. 테스트에 있는 @TestPropertySource
     * 3. @SpringBootTest 애노테이션의 properties 애트리뷰트
     * 4. 커맨드 라인 아규먼트
     *      => $ java -jar target/spring-boot-app-02-1.0-SNAPSHOT.jar --sombrero.name=rey
     * 5. SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는 프로퍼티
     * 6. ServletConfig 파라미터
     * 7. ServletContext 파라미터
     * 8. java:comp/env JNDI 애트리뷰트
     * 9. System.getProperties() 자바 시스템 프로퍼티
     * 10. OS 환경 변수
     * 11. RandomValuePropertySource
     * 12. JAR 밖에 있는 특정 프로파일용 application properties
     * 13. JAR 안에 있는 특정 프로파일용 application properties
     * 14. JAR 밖에 있는 application properties
     * 15. JAR 안에 있는 application properties
     * 16. @PropertySource
     * 17. 기본 프로퍼티 (SpringApplication.setDefaultProperties)
     */

    /**
     * $ mvn clean package -DskipTests
     */
}
