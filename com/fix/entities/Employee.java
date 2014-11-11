package com.fix.entities;

// Generated 4 nov. 2014 17:41:08 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "gf_test")
public class Employee implements java.io.Serializable {

	private Integer empId;
	private String empName;
	private Date empHireDate;
	private BigDecimal empSalary;

	public Employee() {
	}

	public Employee(String empName, Date empHireDate, BigDecimal empSalary) {
		this.empName = empName;
		this.empHireDate = empHireDate;
		this.empSalary = empSalary;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EMP_ID", unique = true, nullable = false)
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(name = "EMP_NAME", length = 45)
	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EMP_HIRE_DATE", length = 19)
	public Date getEmpHireDate() {
		return this.empHireDate;
	}

	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}

	@Column(name = "EMP_SALARY", precision = 11, scale = 4)
	public BigDecimal getEmpSalary() {
		return this.empSalary;
	}

	public void setEmpSalary(BigDecimal empSalary) {
		this.empSalary = empSalary;
	}

}