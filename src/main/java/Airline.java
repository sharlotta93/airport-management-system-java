public enum Airline {

    EASYJET("EasyJet"),
    KLM("KLM"),
    BRITISHAIRWAYS("British AirWays"),
    VUELING("Vueling"),
    RYANAIR("Ryanair"),
    NORWEGIANAIRSHUTTLE("Norwegian Air Shuttle"),
    AEROFLOT("Aeroflot");

    private final String name;

    Airline(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
