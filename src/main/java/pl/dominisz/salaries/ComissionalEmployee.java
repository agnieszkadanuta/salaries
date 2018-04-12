package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class ComissionalEmployee extends Employee {


    public ComissionalEmployee(String name) {
        super(name);
    }
    //commision
    //salary

    @Override
    public BigDecimal getSalary(LocalDate date) {
        if (isPayDay(date)) {
            return computeSalary(date);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal computeSalary(LocalDate date) {
        return BigDecimal.ZERO;
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
