package com.example.demo.repository;

import com.example.demo.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {


}