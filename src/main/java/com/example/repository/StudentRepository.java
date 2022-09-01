package com.example.repository;

import com.example.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO student (name, age) VALUES (?, ?)";

        jdbc.update(sql, student.getName(), student.getAge());
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";

        jdbc.update(sql, id);
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";

        RowMapper<Student> studentRowMapper = (r, i) -> {
            int id = r.getInt("id");
            String name = r.getString("name");
            int age = r.getInt("age");

            return new Student(id, name, age);
        };

        return jdbc.query(sql, studentRowMapper);
    }
}