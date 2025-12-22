package com.mr486.tda.repository;

import com.mr486.tda.model.Ami;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AmiRepositoryImpl implements AmiRepository {

    private final List<Ami> amis = List.of(
            new Ami(1, "Guest", "inconnu.png", true),
            new Ami(2, "Bernard", "inconnu.png", true),
            new Ami(3, "Dan", "inconnu.png", false),
            new Ami(4, "Etienne", "inconnu.png", false),
            new Ami(5, "Fabrice", "inconnu.png", false),
            new Ami(6, "Fanny", "inconnu.png", true),
            new Ami(7, "JP", "inconnu.png", false),
            new Ami(8, "Laurent", "inconnu.png", false)
    );

    @Override
    public List<Ami> findAll() {
        return amis;
    }

    @Override
    public Optional<Ami> findById(Integer id) {
        return amis.stream().filter(ami -> ami.getId().equals(id)).findFirst();
    }
}
