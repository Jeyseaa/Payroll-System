class Employee {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

  
    public Employee(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

   
    public void addHoursWorked(int hours) {
        this.hoursWorked += hours;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

   
    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}
