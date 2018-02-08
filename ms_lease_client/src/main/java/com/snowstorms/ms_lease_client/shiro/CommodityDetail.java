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
@Table(name="t_commodity_detail")
public class CommodityDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer commoditydetailid;
	
	@NotEmpty(message="开始时间不能为空")
	private String begintime;
	
	@NotEmpty(message="结束时间不能为空")
	private String endtime;
	
	@NotEmpty(message="商品价格不能为空")
	private Double price;
	
	@NotEmpty(message="商品状态次状态  0被禁止租借 1正常 2过期 3正在租借中 ")
	private Integer commodity_detail_status;
	
	@ManyToOne
	@JoinColumn(name="commodity_id")
	private Commodity commodity;   //多个商品详情 对一个商品
}
