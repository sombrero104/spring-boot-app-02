package sombrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableConfigurationProperties(SombreroProperties.class)
public class Application {

    /**
     * @EnableConfigurationProperties(SombreroProperties.class) 는
     * 자동으로 등록되어 있음. SombreroProperties.class에 @Component를 설정해서 빈으로 등록해주기만 하면 됨.
     */


    /**
     * 프로퍼티즈가 Third-Party, 즉 외부에 있는 경우.
     * 흔치 않음.
     */
    @ConfigurationProperties("server")
    @Bean
    public ServerProperties serverProperties() {
        return new ServerProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
