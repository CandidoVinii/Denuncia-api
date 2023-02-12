package com.example.apidenuncias.repository;

import com.example.apidenuncias.model.Denuncia;
import com.example.apidenuncias.model.Denunciante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    Denunciante save(Denunciante denunciante);
}
