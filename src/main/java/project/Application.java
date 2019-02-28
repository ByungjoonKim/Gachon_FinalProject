package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import project.domain.Project;
import project.domain.User;
import project.repository.ProjectRepository;
import project.repository.UserRepository;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
     //런타임시 테스트용 데이터 삽입
    @Bean
    public CommandLineRunner runn(ProjectRepository projectRepository, UserRepository userRepository) throws Exception{
        return (args)->{
            User user=userRepository.save(User.builder()
                    .name("chaebin")
                    .address("인천시")
                    .createDate(LocalDateTime.now())
                    .email("chaebin@gmail.com")
                    .tel("010-0000-0000")
                    .build());

            IntStream.rangeClosed(1,200).forEach(index->
                    projectRepository.save(Project.builder()
                        .title("이것은 제목"+index+" 입니다")
                        .start(LocalDateTime.now().plusDays(index))
                        .end(LocalDateTime.now().plusDays(index+5))
                        .volunteer(index)
                        .contents("이것은 내용입니다")
                        .success(false)
                        .alldonation(100+index)
                        .mindonation(index)
                        .secret(false)
                        .minvol(100000+index)
                        .build())
            );

        };
    }
}