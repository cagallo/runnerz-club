package com.chez_gallo.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findOneById(Integer id) {
        return runs.stream()
                .filter(run -> Objects.equals(run.id(), id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update (Run run, Integer id) {
        Optional<Run> existingRun = findOneById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(
                1,
                "Monday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.OUTDOOR));

        runs.add(new Run(2,
                "Monday Night Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(45, ChronoUnit.MINUTES),
                4,
                Location.OUTDOOR));
    }

}

