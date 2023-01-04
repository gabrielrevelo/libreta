package com.example.demo.repository;

import com.example.demo.domain.Contacto;
import com.example.demo.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {

}