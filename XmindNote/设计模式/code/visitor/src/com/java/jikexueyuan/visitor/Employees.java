package com.java.jikexueyuan.visitor;

import java.util.HashMap;

public class Employees {
    private HashMap<String, Employee> employees;

    public Employees() {
        employees = new HashMap<String, Employee>();
    }

    // 新增
    public void Attach(Employee employee) {
        employees.put(employee.getName(), employee);
    }

    // 离职
    public void Detach(Employee employee) {
        employees.remove(employee);
    }

    public Employee getEmployee(String name) {
        return employees.get(name);
    }

    // 获取补偿
    public void getCompensation() {
        for (Employee employee : employees.values()) {

            System.out.println(employee.getName()
                    + "'s Compensation is "
                    + (employee.getDegree() * employee.getVacationDays() * 100));
        }

    }
}
