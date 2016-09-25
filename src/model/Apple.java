package model;

import utils.ListUtils;

public class Apple {
    private int weight;
    private String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public static AppleBuilder builder() {
        return new AppleBuilder();
    }

    public static class AppleBuilder{
        private int weight;
        private String color;

        public AppleBuilder() {}

        public AppleBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public AppleBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Apple build() {
            return new Apple(this.weight, this.color);
        }
    }
}
