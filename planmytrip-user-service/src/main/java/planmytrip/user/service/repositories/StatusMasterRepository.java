package planmytrip.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import planmytrip.user.service.entities.StatusMaster;

public interface StatusMasterRepository extends JpaRepository<StatusMaster, Long> {

}
