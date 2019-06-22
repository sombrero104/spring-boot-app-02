package sombrero;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
// @TestPropertySource(properties = "sombrero.name=rey")
// @SpringBootTest(properties = {"sombrero.name=rey", "sombrero.fullName=${sombrero.name} 104"})
@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest
public class ApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void propertiesTest() {
        assertThat(environment.getProperty("sombrero.name"))
                // .isEqualTo("sombrero");
                // .isEqualTo("xavier");
                // .isEqualTo("rey");
                .isEqualTo("hide");

        /*assertThat(environment.getProperty("sombrero.fullName"))
                .isEqualTo("rey 104");*/

        /**
         * 어플리케이션이 빌드될 때 클래스패스에 main 코드가 빌드되고 그 다음 test 코드가 빌드되기 때문에
         * main>resources의 프로퍼티즈가 test>resources의 프로퍼티즈 파일로 덮어씌워짐.
         * 만약, main>resources에는 있고 test>resources에는 없는 프로퍼티가 있을 경우
         * 덮어씌워지기 때문에 못찾아서 에러 발생.
         *
         * main과 test 디렉토리 아래에 같은 위치에 있으면 덮어씌워지기 때문에 다른 위치에 프로퍼티즈를 놓는 방법이 있음.
         * 아래 처럼..
         *
         * application.properties 우선 순위 (높은게 낮은걸 덮어 씁니다. 제일 위에 있는게 우선순위가 높음.)
         * 1. file:./config/
         * 2. file:./
         * 3. classpath:/config/
         * 4. classpath:/
         *
         *
         */
    }

}