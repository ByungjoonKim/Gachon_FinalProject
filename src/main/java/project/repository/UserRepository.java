package project.repository;

import project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    //아이디 조회
    User findById(String id);
    User findByEmail(String email);

}
