package me.plainoldmoose.IDLuk_MS.player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    public List<Player> getPlayers() {
        return List.of(
                new Player(1, "Moose", 500),
                new Player(2, "Steve", 400));
    }
}
