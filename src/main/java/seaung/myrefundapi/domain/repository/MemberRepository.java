package seaung.myrefundapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seaung.myrefundapi.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
