package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class HourlyEmployee extends Employee {

    private static final int STANDARD_HOURS = 8;
    private static final BigDecimal OVERHOUR_RATE = new BigDecimal("1.5");

    private BigDecimal hourlyRate;
    private List<WorkingDay> workingDays;


    public HourlyEmployee(String name, BigDecimal hourlyRate){
        super(name);
        this.hourlyRate = hourlyRate;
        this.workingDays = new ArrayList<>();
    }

    public void addWorkingDay(WorkingDay workingDay) {
        workingDays.add(workingDay);
    }


    @Override
    public BigDecimal computeSalary(LocalDate date) {
        LocalDate firstDay = getFirstDayOfWorkingPeriod(date);
        List<WorkingDay> salariedDays = findWorkingDays(firstDay, date);
        return computeSalary(salariedDays);
    }

    private List<WorkingDay> findWorkingDays(LocalDate firstDay, LocalDate lastDay) {
        return workingDays.stream().filter(workingDay -> workingDay.between(firstDay, lastDay)).collect(Collectors.toList());
    }

    private BigDecimal computeSalary(List<WorkingDay> salariedDays) {
        return salariedDays.stream().map(day -> computeSalary(day)).reduce(BigDecimal.ZERO, BigDecimal::add);
        // metoda "reduce" potrzebuje początkowej wartości i informacji co robimy z elementami strumienia (tutaj dodajemy)
    }

    private BigDecimal computeSalary(WorkingDay workingDay){
        if(workingDay.getHours() <= STANDARD_HOURS){
            return hourlyRate.multiply(new BigDecimal(workingDay.getHours()));
        }else{
            BigDecimal standardSalary = hourlyRate.multiply(new BigDecimal(STANDARD_HOURS));
            BigDecimal overhours = new BigDecimal(workingDay.getHours() - STANDARD_HOURS);
            BigDecimal overhoursSalary = overhours.multiply(hourlyRate).multiply(OVERHOUR_RATE);
            return standardSalary.add(overhoursSalary);
        }
    }

    @Override
    public LocalDate getFirstDayOfWorkingPeriod(LocalDate date) {
        return date.minusDays(4);
    }

    @Override
    public boolean isPayDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.FRIDAY;
    }
}
