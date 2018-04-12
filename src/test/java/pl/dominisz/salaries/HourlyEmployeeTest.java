package pl.dominisz.salaries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    @Test
    void testIsPayDay(){
        Employee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ZERO);
        Assertions.assertTrue(hourlyEmployee.isPayDay(LocalDate.of(2018, 4, 13)));
        Assertions.assertFalse(hourlyEmployee.isPayDay(LocalDate.of(2018, 4, 12)));
    }

}