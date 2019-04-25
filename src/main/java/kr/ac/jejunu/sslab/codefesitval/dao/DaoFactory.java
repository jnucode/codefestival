package kr.ac.jejunu.sslab.codefesitval.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DaoFactory {
    @Bean
    public ProblemDao problemDao() {
        return new ProblemDao(jdbcTemplate());
    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate();
    }
}
