package seaung.myrefundapi.domain.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import seaung.myrefundapi.domain.entity.Refund;

import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
    @Query("select r from Refund r" +
            " join fetch r.member" +
            " where r.member.userId =:userId")
    List<Refund> findRefundsByMember(@Param("userId") String userId);
}
