package seaung.myrefundapi.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(length = 20)
    private String userId;
    @Column(length = 20)
    private String password;
    private String email;
    @Column(length = 11)
    private String phone;

    @Builder
    public Member(String userId, String password, String email, String phone) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
