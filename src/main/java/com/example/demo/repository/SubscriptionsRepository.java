package com.example.demo.repository;

import com.example.demo.entity.Subscriptions;
import com.example.demo.entity.enumSubscriptions.SubscriptionsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Long>{
    @Query(value = "SELECT s FROM Subscriptions s WHERE s.users.id = :userId")
    List<Subscriptions> findByUsers_Id(Long userId);
    @Query(nativeQuery = true, value = """
        SELECT s.service_name as ServiceName
        from subscriptions s
        GROUP BY s.service_name
        order by COUNT(*) DESC
        LIMIT 3""")
    List<SubscriptionsType> findTopSubscriptions();
    boolean existsByUsers_IdAndId(Long userId, Long subscriptionId);
}
