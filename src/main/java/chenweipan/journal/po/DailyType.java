package chenweipan.journal.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daily_type")
public class DailyType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8298710068437139612L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Column(name = "type_name", nullable = false)
	private String typeName;

	@Column(name = "descript", nullable = false)
	private String descript;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
}
