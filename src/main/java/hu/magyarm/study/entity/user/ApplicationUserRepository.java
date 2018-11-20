package hu.magyarm.study.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{
	ApplicationUser findByEmail(String email);
}
