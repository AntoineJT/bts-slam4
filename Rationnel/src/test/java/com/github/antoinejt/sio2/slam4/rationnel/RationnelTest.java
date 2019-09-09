package com.github.antoinejt.sio2.slam4.rationnel;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RationnelTest {
    private Rationnel oneHalf = new Rationnel(1, 2);
    private Rationnel fourMinusFive = new Rationnel(4, -5);

    @Test
    public void toStringTest(){
        assertThat(oneHalf.toString())
                .isEqualTo("1/2");
        assertThat(fourMinusFive.toString())
                .isEqualTo("-4/5");
    }

    @Test
    public void copyTest(){
        assertThat(oneHalf.copy())
                .isEqualToComparingFieldByField(oneHalf);
        assertThat(fourMinusFive.copy())
                .isEqualToComparingFieldByField(fourMinusFive);
    }

    @Test
    public void oppositeTest(){
        Rationnel oneHalfOpposite = new Rationnel(-1, 2);
        Rationnel fourMinusFiveOpposite = new Rationnel(-4, -5);

        assertThat(oneHalfOpposite)
                .isEqualToComparingFieldByField(oneHalf.opposite());
        assertThat(fourMinusFiveOpposite)
                .isEqualToComparingFieldByField(fourMinusFive.opposite());
    }

    @Test
    public void isPositiveTest(){
        assertThat(true)
                .isEqualTo(oneHalf.isPositive());
        assertThat(false)
                .isEqualTo(fourMinusFive.isPositive());
    }

    @Test
    public void addTest(){
        Rationnel sameDenominatorAsOneHalf = new Rationnel(3, 2);
        Rationnel sameDenominatorAdditionResult = new Rationnel(4, 2);
        Rationnel additionResult = new Rationnel(-3, 10);

        assertThat(oneHalf.add(sameDenominatorAsOneHalf))
                .isEqualToComparingFieldByField(sameDenominatorAdditionResult);
        assertThat(oneHalf.add(fourMinusFive))
                .isEqualToComparingFieldByField(additionResult);
    }

    @Test
    public void multiplyTest(){
        Rationnel multiplyResult = new Rationnel(-4, 10);
        Rationnel secondResult = new Rationnel(4 * -4, -5 * 10);

        assertThat(oneHalf.multiply(fourMinusFive))
                .isEqualToComparingFieldByField(multiplyResult);
        assertThat(fourMinusFive.multiply(multiplyResult))
                .isEqualToComparingFieldByField(secondResult);
    }

    @Test
    public void divideTest(){
        Rationnel oneHalfDividedByFourMinusFive = new Rationnel(-5, 8);
        Rationnel fourMinusFiveDividedByOneHalf = new Rationnel(8, -5);

        assertThat(oneHalf.divide(fourMinusFive))
                .isEqualToComparingFieldByField(oneHalfDividedByFourMinusFive);
        assertThat(fourMinusFive.divide(oneHalf))
                .isEqualToComparingFieldByField(fourMinusFiveDividedByOneHalf);
    }

    @Test
    public void compareToTest(){
        Rationnel oneHalfCopy = oneHalf.copy();

        assertThat(oneHalf.compareTo(oneHalf))
                .isEqualTo(Rationnel.Comparaison.EGAL);
        assertThat(oneHalf.compareTo(oneHalfCopy))
                .isEqualTo(Rationnel.Comparaison.EGAL);
        assertThat(oneHalf.compareTo(fourMinusFive))
                .isEqualTo(Rationnel.Comparaison.SUPERIEUR);
        assertThat(fourMinusFive.compareTo(oneHalf))
                .isEqualTo(Rationnel.Comparaison.INFERIEUR);
    }
}
