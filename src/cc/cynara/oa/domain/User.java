package cc.cynara.oa.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User implements Serializable{
	private Long id; //用户的id
	private String loginName;//登录名
	private String password;//登录密码
	private String name;//真实名
	private String gender;//性别
	private String phone;//手机号
	private String email;//邮箱
	private String description;//说明
	private Department department;//所属部门
	private Set<Role> roles = new HashSet<Role>();//所属岗位
	
	/**
	 * 判断当前用户是否有指定名称的权限
	 * @param privName 权限的名称
	 * @return
	 */
	public boolean hasPrivilegeByName(String privName){
		//如果是超级管理员  就有所有权限
		if("admin".equals(loginName)){
			return true;
		}
		for(Role role :roles){
			for(Privilege p :role.getPrivileges()){
				if(p.getName().equals(privName)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasPrivilegeByUrl(String privUrl) {
		//如果是超级管理员  就有所有权限
		if("admin".equals(loginName)){
			return true;
		}
		//判断url是否是公共url  如果是则返回true
		Collection<String> allPrivilegeUrls = (Collection<String>)ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if(!allPrivilegeUrls.contains(privUrl)){
			return true;
		}else{
			//如果不是公共的url 则需要进一步判断
			for(Role role :roles){
				for(Privilege p :role.getPrivileges()){
					if(privUrl.equals(p.getUrl())){
						return true;
					}
				}
			}
			return false;
		}
		
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
