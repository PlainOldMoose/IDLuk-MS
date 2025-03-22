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
    private Integer elo;

    public Player() {
    }

    public Player(long ID, String name, Integer elo) {
        this.ID = ID;
        this.elo = elo;
        this.name = name;
    }

    public Player(String name, Integer elo) {
        this.elo = elo;
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Integer getElo() {
        return elo;
    }

    public void setElo(Integer elo) {
        this.elo = elo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
