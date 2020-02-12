package gn.traore.embedable.demoembedabledata.repository;

import gn.traore.embedable.demoembedabledata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
