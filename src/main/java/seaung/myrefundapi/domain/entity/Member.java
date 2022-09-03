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
    private String user_id;
    @Column(length = 20)
    private String password;
    private String email;
    @Column(length = 10)
    private String phone;

    @Builder
    public Member(Long id, String user_id, String password, String email, String phone) {
        this.id = id;
        this.user_id = user_id;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
