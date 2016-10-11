package designPatterns.builderPatterns;

/**
 * Created by Nimrod Golan on 21/08/2016.
 */
public class Pizza {

    private final Size size;
    private final boolean isExtraCheese;
    private final boolean isPeperonni;
    private final boolean isBacon;

    public enum Size {
        SMALL, MEDIUM, BIG
    }

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.isExtraCheese = builder.isExtraCheese;
        this.isPeperonni = builder.isPeperonni;
        this.isBacon = builder.isBacon;
    }

    public static class Builder {
        private final Size size;

        private boolean isExtraCheese = false;
        private boolean isPeperonni = false;
        private boolean isBacon = false;

        public Builder(Size size) {
            this.size = size;
        }

        public Builder withExtraCheese() {
            this.isExtraCheese = true;
            return this;
        }

        public Builder withPeperonni() {
            this.isPeperonni = true;
            return this;
        }

        public Builder withBacon() {
            this.isBacon = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
