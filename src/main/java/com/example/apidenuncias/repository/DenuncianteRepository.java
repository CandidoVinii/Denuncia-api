package com.example.apidenuncias.repository;

import com.example.apidenuncias.model.Denunciante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenuncianteRepository extends JpaRepository<Denunciante, Long> {
}
