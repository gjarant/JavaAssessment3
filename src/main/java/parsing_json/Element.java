package parsing_json;

import java.util.ArrayList;

public class Element {

    public String name;
    public String appearance;
    public double atomic_mass;
    public double boil;
    public String category;
    public String color;
    public double density;
    public String discovered_by;
    public double melt;
    public double molar_heat;
    public String named_by;
    public int number;
    public int period;
    public String phase;
    public String source;
    public String spectral_img;
    public String summary;
    public String symbol;
    public int xpos;
    public int ypos;
    public ArrayList<Integer> shells;

    public Element(String name, String appearance, double atomic_mass, double boil, String category, String color, double density, String discovered_by, double melt, double molar_heat, String named_by, int number, int period, String phase, String source, String spectral_img, String summary, String symbol, int xpos, int ypos, ArrayList<Integer> shells) {
        this.name = name;
        this.appearance = appearance;
        this.atomic_mass = atomic_mass;
        this.boil = boil;
        this.category = category;
        this.color = color;
        this.density = density;
        this.discovered_by = discovered_by;
        this.melt = melt;
        this.molar_heat = molar_heat;
        this.named_by = named_by;
        this.number = number;
        this.period = period;
        this.phase = phase;
        this.source = source;
        this.spectral_img = spectral_img;
        this.summary = summary;
        this.symbol = symbol;
        this.xpos = xpos;
        this.ypos = ypos;
        this.shells = shells;
    }

    public String getName() {
        return name;
    }

    public String getAppearance() {
        return appearance;
    }

    public double getAtomic_mass() {
        return atomic_mass;
    }

    public double getBoil() {
        return boil;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public double getDensity() {
        return density;
    }

    public String getDiscovered_by() {
        return discovered_by;
    }

    public double getMelt() {
        return melt;
    }

    public double getMolar_heat() {
        return molar_heat;
    }

    public String getNamed_by() {
        return named_by;
    }

    public int getNumber() {
        return number;
    }

    public int getPeriod() {
        return period;
    }

    public String getPhase() {
        return phase;
    }

    public String getSource() {
        return source;
    }

    public String getSpectral_img() {
        return spectral_img;
    }

    public String getSummary() {
        return summary;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public ArrayList<Integer> getShells() {
        return shells;
    }
}