package project.controller;

import project.domain.Project;
import project.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }
    @GetMapping("/{num}")
    public String project_page(@PathVariable long num, Model model){
        Project project=projectRepository.findBynumber(num);
        model.addAttribute("project",project);
        return "/project/project";
    }
}
