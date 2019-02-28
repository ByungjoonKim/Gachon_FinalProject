package project.domain;
import project.domain.enums.LoginType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class User implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address="";

    @Column
    private String email="";

    @Column
    private String password;

    @Column
    private String tel;

    @Column
    private LocalDateTime createDate;



    @Column
    private String pincipal;

    // 회원가입 타입 (기본값 : HOMEPAGE(홈페이지 가입))
    @Column
    @Enumerated(EnumType.STRING)
    private LoginType loginType = LoginType.HOMEPAGE;

    @Builder
    public User(String name, String address, String email, String password, String tel, LocalDateTime createDate, String pincipal, LoginType loginType) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.createDate = createDate;
        this.pincipal = pincipal;
        this.loginType = loginType;
    }
}
