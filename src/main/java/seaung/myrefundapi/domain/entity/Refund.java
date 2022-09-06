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
    private Long refund;
    @Column(name = "`year`")
    private int year;
    private int salary;
    private int tax;

    @Builder
    public Refund(Long id, Member member, Long refund, int year, int salary, int tax) {
        this.id = id;
        this.member = member;
        this.refund = refund;
        this.year = year;
        this.salary = salary;
        this.tax = tax;
    }
}
