package org.example.springbootjdbc.repo;

import org.example.springbootjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbcTemplate() {
        return jdbc;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    public void save(Student s) {
        String sql="insert into student(id,name,mark) values(?,?,?)";
        jdbc.update(sql,s.getId(),s.getName(),s.getMark());
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student> mapper = (rs,rowNum) ->
        {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setMark(rs.getInt("mark"));
            return s;
        };

        return jdbc.query(sql, mapper);
    }
}
