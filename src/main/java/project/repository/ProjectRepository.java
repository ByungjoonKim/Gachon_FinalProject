package project.repository;

import project.domain.Project;
import project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findBynumber(Long number);
}
