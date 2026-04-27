package com.coffee.entity;

import com.coffee.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity // JPA에게 이 클래스는 DB랑 연결해서 관리해야 할 클래스라는 것을 알리는 어노테이션
@Table(name = "members") // 테이블로 설정하고 테이블 이름을 설정함
public class Member {
    @Id // 프라이머리 키로 설정하기
    // 값 생성하는 어노테이션
    // 방법으로 자동 생성하는 값을 넣음
    @GeneratedValue(strategy = GenerationType.AUTO)
    // 컬럼명 따로 설정하기 - 자바의 변수명은 id지만 DB컬럼명은 member_id가 됨
    @Column(name = "member_id")// pk컬럼명 : 테이블단수명_id
    private Long id ;

    private String name ;

    // 컬럼에 제약조건을 속성으로 설정할 수 있음
    @Column(unique = true, nullable = false)
    private String email ;

    private String password ;
    private String address ;

    // Enum의 상수를 문자열 형태로 DB에 저장하겠다는 어노테이션
    @Enumerated(EnumType.STRING)
    private Role role ;
    private LocalDate regdate ;
}