package com.iain.blog.design.builder;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder(Size.SMALL).addTopping(Topping.SAUSAGE).addTopping(Topping.ONION);
        NyPizza build = builder.build();
        NyPizza build1 = builder.build();

        System.out.println(build.toppings.toString());
        System.out.println(build == build1);
        System.out.println(build1.toppings.toString());
    }
}
