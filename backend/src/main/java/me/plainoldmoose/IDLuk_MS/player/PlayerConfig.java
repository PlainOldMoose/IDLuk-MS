package me.plainoldmoose.IDLuk_MS.player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {
    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository) {
        return args -> {
            Player moose = new Player("Moose", 500);
            Player nick = new Player("Nick", 400);

            repository.saveAll(List.of(moose, nick));
        };
    }
}
