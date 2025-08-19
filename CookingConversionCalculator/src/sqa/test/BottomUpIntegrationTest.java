package sqa.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.main.CookingConversionCalculator;
import sqa.main.TemperatureConverter;
import sqa.main.MassConverter;
import sqa.main.LiquidVolumeConverter;

//ภคพล อยู่ยืน 663380226-7
class BottomUpIntegrationTest {

    TemperatureConverter tempConv;
    MassConverter massConv;
    LiquidVolumeConverter liquidConv;
    CookingConversionCalculator calc;

    @BeforeEach
    void setUp() {
        tempConv = new TemperatureConverter();
        massConv = new MassConverter();
        liquidConv = new LiquidVolumeConverter();
        calc = new CookingConversionCalculator();
    }

    //Test TemperatureConverter
    @Test
    void testTemperatureConverterFtoC() {
        double result = tempConv.convert(212, "fahrenheit", "celsius");
        assertEquals(100, result);
    }

    @Test
    void testTemperatureConverterCtoF() {
        double result = tempConv.convert(100, "celsius", "fahrenheit");
        assertEquals(212, result);
    }

    //Test MassConverter 
    @Test
    void testMassConverterCupToGram() {
        double result = massConv.convert(2, "cup", "gram");
        assertEquals(250, result);
    }

    @Test
    void testMassConverterTbspToGram() {
        double result = massConv.convert(3, "tablespoon", "gram");
        assertEquals(24, result);
    }

    //Test LiquidVolumeConverter 
    @Test
    void testLiquidConverterCupToMl() {
        double result = liquidConv.convert(1, "cup", "ml");
        assertEquals(250, result);
    }

    @Test
    void testLiquidConverterTbspToMl() {
        double result = liquidConv.convert(2, "tablespoon", "ml");
        assertEquals(30, result);
    }

    //Test CookingConversionCalculator
    @Test
    void testCalculatorMassConversion() {
        double result = calc.convert(2, "mass", "cup", "gram");
        assertEquals(250, result);
    }

    @Test
    void testCalculatorLiquidConversion() {
        double result = calc.convert(1, "liquid", "cup", "ml");
        assertEquals(250, result);
    }

    @Test
    void testCalculatorTemperatureConversion() {
        double result = calc.convert(212, "temperature", "fahrenheit", "celsius");
        assertEquals(100, result);
    }
}
