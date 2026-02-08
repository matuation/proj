package com.stepup.proj;

public class Fraction {
    private int numerator = 0;
    private int denominator = 0;

    private Fraction(int numerator, int denominator) {
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным!");
        }
        this.denominator = denominator;
        this.numerator = numerator;

    }

    public static Fraction of(int numerator, int denominator) {
        return new Fraction(numerator, denominator);

    }

    public int getNumerator() {
        return numerator;
    }

    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction sum(Fraction fraction) {
        Fraction newFraction = null;
        if (this.denominator == fraction.getDenominator()) {
            int newFractionNumerator = this.numerator + fraction.getNumerator();
            newFraction = Fraction.of(newFractionNumerator, fraction.getDenominator());
        } else {
            int newFractionNumerator = (this.numerator * fraction.getDenominator()) + (fraction.getNumerator() * this.getDenominator());
            int newFractionDenominator = this.denominator * fraction.getDenominator();
            newFraction = Fraction.of(newFractionNumerator, newFractionDenominator);
        }
        return newFraction;
    }

    public Fraction sum(int number) {
        Fraction newFraction = null;
        int newFractionNumerator = (this.denominator * number) + this.numerator;
        newFraction = Fraction.of(newFractionNumerator, this.denominator);
        return newFraction;
    }

    public Fraction minus(Fraction fraction) {
        Fraction newFraction = null;
        if (this.denominator == fraction.getDenominator()) {
            int newFractionNumerator = this.numerator - fraction.getNumerator();
            newFraction = Fraction.of(newFractionNumerator, fraction.getDenominator());
        } else {
            int newFractionNumerator = (this.numerator * fraction.getDenominator()) - (fraction.getNumerator() * this.getDenominator());
            int newFractionDenominator = this.denominator * fraction.getDenominator();
            newFraction = Fraction.of(newFractionNumerator, newFractionDenominator);
        }
        return newFraction;
    }

    public Fraction minus(int number) {
        Fraction newFraction = null;
        int newFractionNumerator = this.numerator - (this.denominator * number);
        newFraction = Fraction.of(newFractionNumerator, this.denominator);
        return newFraction;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
