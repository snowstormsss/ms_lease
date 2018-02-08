package com.snowstorms.ms_lease_client.shiro;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "t_user")
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6568139093105454505L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;    
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private List<Role> roleList;// 一个用户具有多个角色
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "t_user_collection", joinColumns = { @JoinColumn(name = "collection_id") }, inverseJoinColumns = {
            @JoinColumn(name = "user_id") })
    private List<User> collectionList;// 一个用户有多个收藏


    public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

    public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    
    @Transient
    public Set<String> getRolesName() {
        List<Role> roles = getRoleList();
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getRolename());
        }
        return set;
    }

	@Override
	public String toString() {
		return "User [id=" + userid + ", username=" + username + ", password=" + password + ", roleList=" + roleList + "]";
	}
}