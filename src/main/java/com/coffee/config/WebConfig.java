package com.coffee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 1) WebConfig 클래스를 @Configuration 어노테이션에 의하여 Spring Boot의 설정 클래스로 등록
@Configuration // 이 파일은 스프링에서 설정용 파일로 사용하겠습니다.
// 2) WebMvcConfigurer를 상속받기
public class WebConfig implements WebMvcConfigurer {
    @Override // 3) addCorsMappings 메소드 오버라이딩하기
    public void addCorsMappings(CorsRegistry registry) {
        // 3000번 포트에서 GET부터 PATCH까지의 열거한 요청들을 모두 수락하겠습니다.
        registry.addMapping("/**") /* 모든 경로 허용  */ // 모든 URL 허용
                /* react 포트 */
                .allowedOrigins("http://localhost:5173", "http://localhost:3000")
                /* 허용할 메소드 */
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                // 쿠키 전송 허용
                .allowCredentials(true) ;
    }
}