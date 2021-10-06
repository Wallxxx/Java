class Populations {
    private final String city;
    private final int population;

    public Populations(String name, int people) {
        city = name;
        population = people;
    }

    public String getCity() {
        return city;
    }

    public int getPopulation() {
        return population;
    }
}
