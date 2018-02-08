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
@Table(name="t_picture_detail")
public class PictureDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer picturedetailid;
	
	@NotEmpty(message="图片详情路径不能为空")
	private String path;
	
	@ManyToOne
	@JoinColumn(name="picture_id")
	private Picture picture;
}
