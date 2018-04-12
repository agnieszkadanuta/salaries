package pl.dominisz.salaries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MonthlyEmployeeTest {

    @Test
    void testIsPayDayShouldBeFalseForNonWorkingDay(){
        MonthlyEmployee monthlyEmployee = new MonthlyEmployee("name", BigDecimal.ONE);
        Assertions.assertFalse(monthlyEmployee.isPayDay(LocalDate.of(2018,6,30)));
        Assertions.assertFalse(monthlyEmployee.isPayDay(LocalDate.of(2018,5,30)));
    }

    @Test
    void testIsPayDayShouldReturnTrueForLastWorkingDayOfMonth(){
        MonthlyEmployee monthlyEmployee = new MonthlyEmployee("name", BigDecimal.ONE);
        Assertions.assertTrue(monthlyEmployee.isPayDay(LocalDate.of(2018,4,30)));
        Assertions.assertTrue(monthlyEmployee.isPayDay(LocalDate.of(2018,6,29)));
    }


}