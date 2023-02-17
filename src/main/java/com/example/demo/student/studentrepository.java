package com.example.demo.student;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface studentrepository extends JpaRepository<student, Long>{

    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<student> findStudentByEmail(String email);

    @Modifying
    @Query("UPDATE student s SET s.name = ?1, s.email = ?2 WHERE s.id = ?3")
    void updatestudent(String name, String email, Long id);


}