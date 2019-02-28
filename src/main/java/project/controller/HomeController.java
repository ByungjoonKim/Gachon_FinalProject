package project.controller;


import project.domain.User;
import project.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService){this.homeService=homeService;}

    @GetMapping("")
    public String list(@PageableDefault(size=4) Pageable pageable,User user, Model model) {
        //최근에 프로젝트
        model.addAttribute("ProjectList", homeService.findBoardList(pageable));

        //인기있는 프로젝트
        return "home";
    }
}
