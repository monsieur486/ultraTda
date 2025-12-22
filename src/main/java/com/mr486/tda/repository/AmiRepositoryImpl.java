package com.mr486.tda.repository;

import com.mr486.tda.model.Ami;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AmiRepositoryImpl implements AmiRepository {

    private final List<Ami> amis = List.of(
            new Ami(1, "Guest", "inconnu.png", true),
            new Ami(2, "Bernard", "trombi_bernard.png", true),
            new Ami(3, "Dan", "trombi_dan.png", false),
            new Ami(4, "Etienne", "trombi_etienne.png", false),
            new Ami(5, "Fabrice", "inconnu.png", false),
            new Ami(6, "Fanny", "inconnu.png", true),
            new Ami(7, "JP", "trombi_jp.png", false),
            new Ami(8, "Laurent", "trombi_laurent.png", false)
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
