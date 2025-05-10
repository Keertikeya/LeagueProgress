package org.arcl.libs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

public class Batsman {
    private String name;
    private String team;
    private int runs;
    private int ballsFaced;
    private int fours;
    private int sixes;
    private float strikeRate;
    // private int highestScore; // To be implemented

    public Batsman(String name, String team, int runs, int ballsFaced, int fours, int sixes) {
        this.name = name;
        this.team = team;
        this.runs = runs;
        this.ballsFaced = ballsFaced;
        this.fours = fours;
        this.sixes = sixes;
        this.strikeRate = getStrikeRate();
    }

    public float getStrikeRate() {
        if (this.ballsFaced == 0) {
            return 0.00f;
        }

        BigDecimal result = new BigDecimal((float)this.runs / this.ballsFaced);
        result = result.setScale(2, RoundingMode.HALF_UP);

        return result.floatValue();
    }

    public int getRuns() {
        return this.runs;
    }

    public static Comparator<Batsman> mostRunsComparator = Comparator.comparingInt(Batsman::getRuns).reversed();

    public String runsInfo() {
        return String.format("%s (%s) - %d", this.name, this.team, this.runs);
    }

    @Override
    public String toString() {
        return String.format(
            "%s\t%s\t%d\t%d\t%.2f",
            this.name,
            this.team,
            this.runs,
            this.ballsFaced,
            this.strikeRate
        );
    }
}
