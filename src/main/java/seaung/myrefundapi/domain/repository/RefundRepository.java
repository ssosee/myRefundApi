package seaung.myrefundapi.domain.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import seaung.myrefundapi.domain.entity.Refund;

import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
    @Query("select distinct r from Refund r" +
            " join fetch r.member")
    List<Refund> findRefundsByMember();
}
