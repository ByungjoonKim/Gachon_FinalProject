package project.service;


import project.domain.Project;
import project.repository.ProjectRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final ProjectRepository projectRepository;

    public HomeService(ProjectRepository projectRepository){this.projectRepository=projectRepository;}

    public Page<Project> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return projectRepository.findAll(pageable);
    }

    public Project findProjectByIdx(Long idx){
        return projectRepository.findById(idx).orElse(new Project());
    }

}
