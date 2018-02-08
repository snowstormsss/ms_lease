package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer commentid;
	
	@NotEmpty(message="评论内容不能为空")
	private String content;
	
	@ManyToOne 
	private Comment parent;  //父节点
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="parent")
	@OrderBy("commentid")
	private List<Comment> childrens;//子节点
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;// 属于一个用户
	
	@ManyToOne
	@JoinColumn(name="commodity_id")
	private Commodity commodity;   //属于一个商品
}
