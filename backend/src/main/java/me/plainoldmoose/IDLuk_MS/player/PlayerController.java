package me.plainoldmoose.IDLuk_MS.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService service) {
        this.playerService = service;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }
}
