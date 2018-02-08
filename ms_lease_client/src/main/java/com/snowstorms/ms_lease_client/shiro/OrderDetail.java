package com.snowstorms.ms_lease_client.shiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderdetailid;
	
	@OneToOne
	@JoinColumn(name="commoditydetail_id")
	private CommodityDetail commodityDetail;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders order;
}
