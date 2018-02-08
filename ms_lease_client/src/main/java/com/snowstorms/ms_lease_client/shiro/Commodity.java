package com.snowstorms.ms_lease_client.shiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_commodity")
public class Commodity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer commodityid;
	
	@NotEmpty(message="商品名称不能为空")
	private String commodityname;
	
	@NotEmpty(message="商品描述不能为空")
	private String information;
	
	@NotEmpty(message="商品主状态 0被管理员禁止租借 1正常 2被商家禁止租借")
	private Integer commodity_status;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;// 多个商品对应一个角色

	public Integer getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(Integer commodityid) {
		this.commodityid = commodityid;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
