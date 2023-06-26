package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

/**
 * Employee管理サービス
 * Created by Liu on 2023/4/19.
 */
public interface EmployeeService {

    /**
     * Employee検索
     */
    public List<Employee> retrieveEmployees();

    /**
     * Employee詳細検索
     */
    public Employee getEmployee(Long employeeId);

    /**
     * Employee作成
     */
    public int createEmployee(Employee employee);

    /**
     * Employee削除
     */
    public void deleteEmployee(Employee employee);

    /**
     * Employee更新
     */
    public void updateEmployee(Employee employee);
}