package com.jasper.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jasper.bean.EmployeeBean;
import com.jasper.bean.SalaryBean;
import com.jasper.model.DeptEmp;
import com.jasper.model.Employee;
import com.jasper.model.Salary;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<EmployeeBean> getEmployees() {
		List<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		try {
			Session session=this.getSessionFactory().openSession();			
			try {
				List<Employee> employees=session.createQuery("from Employee group by empNo").setMaxResults(100).list();
				System.out.println("Record fetch:"+employees.size());
				for (Employee employee:employees) {
					EmployeeBean employeeBean=new EmployeeBean();
					employeeBean.setBirthDate(employee.getBirthDate());
					employeeBean.setEmpNo(employee.getEmpNo());
					employeeBean.setFirstName(employee.getFirstName());
					employeeBean.setGender(employee.getGender());
					employeeBean.setHireDate(employee.getHireDate());
					employeeBean.setLastName(employee.getLastName());
					List<Salary> salaryList=session.createQuery("from Salary where employee.empNo=:empNo").setParameter("empNo", employee.getEmpNo()).list();
					List<SalaryBean> salaryBeans=new ArrayList<SalaryBean>();
					for (Salary salary:salaryList) {
						SalaryBean salaryBean=new SalaryBean();
						salaryBean.setDate(salary.getToDate());
						salaryBean.setSalary(salary.getSalary());
						salaryBeans.add(salaryBean);
					}
					employeeBean.setSalaryList(salaryBeans);
					//DeptEmp deptEmp=(DeptEmp) session.createQuery("from DeptEmp where employee.empNo=:empNo").setParameter("empNo", employee.getEmpNo()).uniqueResult();
					employeeBean.setDepartment(employee.getDeptEmps().get(0).getDepartment().getDeptName().trim());
					System.out.println("Record fetch-----------:"+employees.size());
					employeeList.add(employeeBean);
				}
			} catch (Exception e) {
				throw e;
			} finally {
				try {
					session.close();
				} catch (Exception e2) {
					throw e2;
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
		// TODO Auto-generated method stub
		return employeeList;
	}
	
}
