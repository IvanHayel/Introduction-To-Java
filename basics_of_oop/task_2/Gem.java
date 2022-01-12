package basics_of_oop.task_2;

public enum Gem {
    AQUAMARINE("aquamarine"),
    DIAMOND("diamond"),
    RUBY("ruby"),
    EMERALD("emerald"),
    TOPAZ("topaz"),
    GARNET("garnet"),
    BERYL("beryl"),
    SAPPHIRE("sapphire"),
    AMETHYST("amethyst"),
    OPAL("opal");

    private final String gem;

    Gem(String gem) {
        this.gem = gem;
    }

    @Override
    public String toString() {
        return gem;
    }
}