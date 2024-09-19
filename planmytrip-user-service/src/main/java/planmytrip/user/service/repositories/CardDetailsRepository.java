package planmytrip.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import planmytrip.user.service.entities.CardDetails;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {

}
