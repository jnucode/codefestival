package kr.ac.jejunu.sslab.codefesitval.dto;

import lombok.Data;

@Data
public class Problem {
    private Long id;
    private Long level;
    private String title;
    private String content;
    private String answer;
    private String parameter;
    private String returnType;
}
