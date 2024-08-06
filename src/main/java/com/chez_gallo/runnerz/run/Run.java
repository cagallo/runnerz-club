package com.chez_gallo.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

    public Run {
        if(!startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("Started on cannot be after completed on");
        }
    }

}

