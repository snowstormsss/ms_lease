package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_collection")
public class Collection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer collectionid;
	
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "t_user_collection", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "collection_id") })
    private List<User> userList;// 一个收藏属于多个用户
	
    @NotEmpty(message="收藏时价格")
	private Double before_price;
	
	@OneToOne
	@JoinColumn(name="commodity_id")   //单向一对一收藏 对应的商品
	private Commodity commodity;
}
