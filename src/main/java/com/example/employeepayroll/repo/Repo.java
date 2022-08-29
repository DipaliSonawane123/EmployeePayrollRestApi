package com.example.employeepayroll.repo;

import com.example.employeepayroll.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Model , Long> {
}
