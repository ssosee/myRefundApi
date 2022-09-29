package seaung.myrefundapi.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refunds_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private float refund;
    @Column(name = "`year`")
    private int year;
    private float salary; //근로소득
    private float tax; //납부세액

    @Builder
    public Refund(Long id, Member member, float refund, int year, float salary, float tax) {
        this.id = id;
        this.member = member;
        this.refund = refund;
        this.year = year;
        this.salary = salary;
        this.tax = tax;
    }
}
