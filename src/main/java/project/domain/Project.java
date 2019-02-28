package project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Created by chaebin on 2019-02-19
 *
 */

@Entity
@NoArgsConstructor
@Getter
@Table
public class Project implements Serializable {
    //프로젝트 번호
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    //사용자 아이디
    @OneToOne(fetch=FetchType.LAZY)
    private User user;

    //작성자 이름
    @Column
    private String writer;

    //프로젝트 제목
    @Column
    private String title;

    //프로젝트 신청 날짜
    @Column
    private LocalDateTime start;

    //프로젝트 종료 날짜
    @Column
    private LocalDateTime end;

    //자원봉사 신청 수
    @Column
    private Integer volunteer;

    //프로젝트 내용
    @Lob
    @Column
    private String contents;

    //프로젝트 삭제 여부
    @Column
    private boolean del;

    //프로젝트 성공 도달 여부
    @Column
    private boolean success;

    //실시간 모금 금액
    @Column
    private Integer alldonation;

    //프로젝트 상태
    //private State state;

    //프로젝트 최소 자원 봉사수
    @Column
    private Integer mindonation;

    //비공개형 프로젝트 여부
    @Column
    private boolean secret;

    //프로젝트 최소 모금
    @Column
    private Integer minvol;

    @Builder
    public Project(String writer, String title, LocalDateTime start, LocalDateTime end, Integer volunteer, String contents, boolean del, boolean success, Integer alldonation, Integer mindonation, boolean secret, Integer minvol) {
        this.writer = writer;
        this.title = title;
        this.start = start;
        this.end = end;
        this.volunteer = volunteer;
        this.contents = contents;
        this.del = del;
        this.success = success;
        this.alldonation = alldonation;
        this.mindonation = mindonation;
        this.secret = secret;
        this.minvol = minvol;
    }
}
