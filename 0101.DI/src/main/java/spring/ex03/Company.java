package spring.ex03;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Company {
	List<Department> deptList;
	Set<Department> deptSet;
	Map<String,Department> deptMap;
	
	public Company() {}
	
	public List<Department> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}
	public Set<Department> getDeptSet() {
		return deptSet;
	}
	public void setDeptSet(Set<Department> deptSet) {
		this.deptSet = deptSet;
	}

	public Map<String, Department> getDeptMap() {
		return deptMap;
	}

	public void setDeptMap(Map<String, Department> deptMap) {
		this.deptMap = deptMap;
	}
}
