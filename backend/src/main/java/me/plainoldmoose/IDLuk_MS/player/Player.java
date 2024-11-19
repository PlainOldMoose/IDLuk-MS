package me.plainoldmoose.IDLuk_MS.player;

import jakarta.persistence.*;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "playerSequence",
            sequenceName = "playerSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "playerSequence"
    )
    private long ID;
    private String name;
    private int elo;

    public Player(long ID, String name, int elo) {
        this.ID = ID;
        this.elo = elo;
        this.name = name;
    }

    public Player(String name, int elo) {
        this.elo = elo;
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
