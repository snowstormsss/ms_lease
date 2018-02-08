package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_picture")
public class Picture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer picture_id;
	
	@OneToOne
	@JoinColumn(name="commodity_id")
	private Commodity commodity; //一对一商品
}
