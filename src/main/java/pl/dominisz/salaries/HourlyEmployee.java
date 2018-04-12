package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class HourlyEmployee extends Employee {

    private BigDecimal hourlyRate;

    @Override
    public BigDecimal getSalary(LocalDate date) {
        if (isPayDay(date)) {
            return BigDecimal.ZERO;
        } else {
            return BigDecimal.ZERO;
        }
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
