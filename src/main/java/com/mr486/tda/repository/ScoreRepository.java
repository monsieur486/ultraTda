package com.mr486.tda.repository;

import com.mr486.tda.model.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository {

    List<Score> findAll();
}
