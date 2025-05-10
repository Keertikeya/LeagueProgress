package org.arcl.libs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

public class Bowler {
    private String name;
    private String team;
    private double overs;
    private int runs;
    private int wickets;
    private float average;
    private float economyRate;

    public Bowler(String name, String team, double overs, int runs, int wickets) {
        this.name = name;
        this.team = team;
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;

        this.average = getAverage();
        this.economyRate = getEconomyRate();
    }

    public float getAverage() {
        if (this.wickets == 0) {
            return 999.99f;
        }
        float value = (float) this.runs/this.wickets;
        return new BigDecimal(String.valueOf(value)).setScale(2, RoundingMode.CEILING).floatValue();
    }

    public float getEconomyRate() {
        int numberOfBalls = 0;
        numberOfBalls += ((int) this.overs) * 6;
        numberOfBalls += ((int)(this.overs * 10)%10);

        float value = (float) (this.runs * 6) / numberOfBalls;
        return new BigDecimal(String.valueOf(value)).setScale(2, RoundingMode.CEILING).floatValue();
    }

    public int getWickets() {
        return this.wickets;
    }

    public static Comparator<Bowler> wicketsComparator = Comparator.comparingInt(Bowler::getWickets).reversed();

    public static Comparator<Bowler> EconomyRateComparator = Comparator.comparing(Bowler::getEconomyRate);

    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%d\t%d\t%.2f\t%.2f", this.name, this.team, this.overs, this.runs, this.wickets, this.average, this.economyRate);
    }

    public String wicketsInfo() {
        return String.format("%s (%s) - %d", this.name, this.team, this.wickets);
    }

}
