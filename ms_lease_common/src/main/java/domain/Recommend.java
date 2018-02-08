package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_recommend")
public class Recommend {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer recommendid;
	
	@OneToOne
	@JoinColumn(name="commodity_id")
	private Commodity commodity;
}
