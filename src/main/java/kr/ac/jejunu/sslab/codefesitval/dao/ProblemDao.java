package kr.ac.jejunu.sslab.codefesitval.dao;

import kr.ac.jejunu.sslab.codefesitval.dto.Problem;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.List;

public class ProblemDao {

    private JdbcTemplate jdbcTemplate;

    public ProblemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Problem> getProblem(@Nullable Object[] params) {
        String sql = "select id, level ,title from practice_problem_list";
        List<Problem> list = null;
        try {
            list = jdbcTemplate.query(sql, ((rs, rowNum) -> {
                return new Problem() {{
                    setId(rs.getLong("id"));
                    setLevel(rs.getLong("level"));
                    setTitle(rs.getString("title"));
                }};
            }));
        } catch (EmptyResultDataAccessException e) { }
        return list;
    }

    public Problem getProblemDetail(Long id) {
        String sql = "select * from practice_problem_list where id = ?";
        Object[] params = new Object[] { id };
        Problem problem = null;
        try {
            problem = jdbcTemplate.queryForObject(sql, params, ((rs, rowNum) -> {
                return new Problem() {{
                    setId(rs.getLong("id"));
                    setLevel(rs.getLong("level"));
                    setTitle(rs.getString("title"));
                    setContent(rs.getString("content"));
                    setParameter(rs.getString("parameter"));
                    setReturnType(rs.getString("return_type"));
                }};
            }));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return problem;
    }
}
