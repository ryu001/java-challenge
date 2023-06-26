package jp.co.axa.apidemo.controllers;

import io.swagger.annotations.ApiOperation;
import jp.co.axa.apidemo.common.CommonResult;
import jp.co.axa.apidemo.common.ParamChecker;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Employee管理コントローラー
 * Created by Liu on 2023/4/19.
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("Employeeリスト検索する")
    @GetMapping("/employees")
    public CommonResult<List<Employee>>  getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return CommonResult.success(employees);
    }

    @ApiOperation("IDからEmployee情報を検索する")
    @GetMapping("/employees/{employeeId}")
    public CommonResult<Employee> getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        return CommonResult.success(employee);
    }

    @ApiOperation("Employee作成")
    @PostMapping("/employees")
    public CommonResult createEmployee(@RequestBody Employee employee){
        // パラメータチェック
        if (ParamChecker.lengthCheckErr(employee.getName(), 255))
            return CommonResult.validateFailed("姓名長さ不正です。");
        if (ParamChecker.lengthCheckErr(employee.getDepartment(), 255))
            return CommonResult.validateFailed("部署長さ不正です。");

        int count = employeeService.createEmployee(employee);
        if (count > 0) return CommonResult.success(count);
        else return CommonResult.failed();
    }

    @ApiOperation("Employee削除")
    @DeleteMapping("/employees/{employeeId}")
    public CommonResult deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        // Employee存在チェック
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null) {
            employeeService.deleteEmployee(emp);
            return CommonResult.success(1);
        }
        else return CommonResult.failed();
    }

    @ApiOperation("Employee更新")
    @PutMapping("/employees/{employeeId}")
    public CommonResult updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        // Employee存在チェック
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null) {
            // パラメータチェック
            if (ParamChecker.lengthCheckErr(employee.getName(), 255))
                return CommonResult.validateFailed("姓名長さ不正です。");
            if (ParamChecker.lengthCheckErr(employee.getDepartment(), 255))
                return CommonResult.validateFailed("部署長さ不正です。");
            employee.setId(emp.getId());
            // 削除フラグは更新しない
            employee.setDelete(emp.getDelete());
            employeeService.updateEmployee(employee);
            return CommonResult.success(1);
        }
        else return CommonResult.failed();
    }

}
