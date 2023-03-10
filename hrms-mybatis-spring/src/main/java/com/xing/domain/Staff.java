package com.xing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component//将该类交给是spring容器管理

public class Staff {
    //员工编号
    private Integer employeeId;
    //员工姓名
    private String employeeName;
    //员工部门
    private String department;
    //员工职位
    private String position;

}
