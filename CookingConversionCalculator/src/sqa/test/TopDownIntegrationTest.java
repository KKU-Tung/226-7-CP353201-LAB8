package sqa.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.main.CookingConversionCalculator;
import sqa.main.TemperatureConverter;
import sqa.main.MassConverter;
import sqa.main.LiquidVolumeConverter;

//ภคพล อยู่ยืน 663380226-7
class TopDownIntegrationTest {

    CookingConversionCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new CookingConversionCalculator();
    }

    // Test Stub TemperatureConverter
    @Test
    void testTemperatureWithStub() {
        TemperatureConverter stub = new TemperatureConverter() {
            @Override
            public double convert(double tempValue, String fromUnit, String toUnit) {
                return 37.78; // ค่า stub
            }
        };
        double result = stub.convert(100, "fahrenheit", "celsius");
        assertEquals(37.78, result, 0.01);
    }

    // Test Stub MassConverter
    @Test
    void testMassWithStub() {
        MassConverter stub = new MassConverter() {
            @Override
            public double convert(double massValue, String fromUnit, String toUnit) {
                return 500; // ค่า stub เช่น 500g
            }
        };
        double result = stub.convert(2, "cup", "gram");
        assertEquals(500, result, 0.01);
    }

    // Test Stub LiquidVolumeConverter
    @Test
    void testLiquidWithStub() {
        LiquidVolumeConverter stub = new LiquidVolumeConverter() {
            @Override
            public double convert(double liquidValue, String fromUnit, String toUnit) {
                return 1000; // ค่า stub เช่น 1000ml
            }
        };
        double result = stub.convert(4, "cup", "ml");
        assertEquals(1000, result, 0.01);
    }

    // Test Integration with real MassConverter
    @Test
    void testMassConversion() {
        double result = calc.convert(2, "mass", "cup", "gram");
        assertEquals(250, result, 0.001);
    }

    // Test Integration with real LiquidVolumeConverter
    @Test
    void testLiquidConversion() {
        double result = calc.convert(1, "liquid", "cup", "ml");
        assertEquals(250, result, 0.001);
    }

    // Test Integration with real TemperatureConverter
    @Test
    void testTemperatureConversionReal() {
        double result = calc.convert(212, "temperature", "fahrenheit", "celsius");
        // ตาม requirement 212F ต้องเท่ากับ 100C
        assertEquals(100, result, 0.001);
    }
}
