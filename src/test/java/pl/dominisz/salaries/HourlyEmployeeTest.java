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

    @Test
    void testFindFirstDayOfWorkingPeriod(){
        Employee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ZERO);
        LocalDate expected = LocalDate.of(2018,4,9);
        LocalDate actual = hourlyEmployee.getFirstDayOfWorkingPeriod(LocalDate.of(2018,4,13));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testgetSalaryifDayisdifferentThenFridayShouldReturnZero(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ONE);
        WorkingDay workingDay = new WorkingDay(LocalDate.of(2018,4,12), 8);
        hourlyEmployee.addWorkingDay(workingDay);

        assertEquals(BigDecimal.ZERO, hourlyEmployee.getSalary(LocalDate.of(2018,4,12)));
    }

    @Test
    void testgetSalaryifDayisFridayShouldReturnEight(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee("name", BigDecimal.ONE);
        WorkingDay workingDay = new WorkingDay(LocalDate.of(2018,4,13), 8);
        hourlyEmployee.addWorkingDay(workingDay);
        assertEquals(BigDecimal.valueOf(8), hourlyEmployee.getSalary(LocalDate.of(2018,4,13)));
    }
}