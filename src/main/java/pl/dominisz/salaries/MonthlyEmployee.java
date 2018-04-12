package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class MonthlyEmployee extends Employee {
    //salary


    @Override
    public BigDecimal computeSalary(LocalDate date) {
        return null;
    }

    @Override
    public LocalDate getFirstDayOfWorkingPeriod(LocalDate date) {
        return null;
    }

    @Override
    public boolean isPayDay(LocalDate date) {
        return false;
    }
}
