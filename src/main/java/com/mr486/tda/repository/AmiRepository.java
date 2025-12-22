package com.mr486.tda.repository;

import com.mr486.tda.model.Ami;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AmiRepository {

    List<Ami> findAll();

    Optional<Ami> findById(Integer id);
}
