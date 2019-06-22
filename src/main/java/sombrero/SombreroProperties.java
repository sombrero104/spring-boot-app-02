package sombrero;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@ConfigurationProperties("sombrero")
@Validated // JSR-303 Validation API 의 구현체로 하이버네이트 Validator 를 사용.
public class SombreroProperties {

    @NotEmpty
    private String name;

    private int age;

    private String fullName;

    /**
     * 이 값을 초로 받겠다. 안들어오면 30초.
     * @DurationUnit(ChronoUnit.SECONDS) 설정 없이
     * 프로퍼티즈 파일에서 값 뒤에 s를 붙이면 자동으로 듀레이션해줌.
     */
    // @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessionTimeout = Duration.ofSeconds(30);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
