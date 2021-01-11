package com.satback.satapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satback.satapi.models.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, String> {
	Colaborador findById(long id);
}
