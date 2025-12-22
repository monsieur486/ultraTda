package com.mr486.tda.repository;

import com.mr486.tda.model.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

    private final List<Score> scores = List.of(
            new Score("Eve", -800, "inconnu.png"),
            new Score("Alice", 1500, "inconnu.png"),
            new Score("Bob", -1200, "inconnu.png"),
            new Score("Charlie", -800, "inconnu.png"),
            new Score("Dan", 0, "trombi_dan.png")
    );

    @Override
    public List<Score> findAll() {
        return scores;
    }
}
