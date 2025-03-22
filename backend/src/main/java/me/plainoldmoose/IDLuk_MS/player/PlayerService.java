package me.plainoldmoose.IDLuk_MS.player;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(final PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository.findByName(player.getName());

        if (playerOptional.isPresent()) {
            throw new IllegalArgumentException("Player already exists");
        }

        playerRepository.save(player);
    }

    public void deletePlayer(long playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new IllegalArgumentException("Player does not exist");
        }

        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(long playerId, String name, Integer elo) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new IllegalArgumentException("Player does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(player.getName(), name)) {
            Optional<Player> playerOptional = playerRepository.findByName(name);

            if (playerOptional.isPresent()) {
                throw new IllegalArgumentException("Player already exists");
            }

            player.setName(name);
        }

        if (elo != null && elo >= 0 && !Objects.equals(player.getElo(), elo)) {
            player.setElo(elo);
        }
    }
}
