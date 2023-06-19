package com.project.Horizon.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Horizon.Model.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

    Optional<Student> findByUsername(String username);

    void deleteByPassword(String password);
    
}
