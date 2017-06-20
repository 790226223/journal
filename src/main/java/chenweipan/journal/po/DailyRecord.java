package chenweipan.journal.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daily_record")
public class DailyRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5030238457924472593L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Column(name = "day_time", nullable = false)
	private String dayTime;

	@Column(name = "things", nullable = false)
	private String things;

	@Column(name = "descript")
	private String descript;

	@Column(name = "count")
	private Integer count;

	@Column(name = "units")
	private String units;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "end_time")
	private String endTime;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "type_id")
	private Integer typeId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDayTime() {
		return dayTime;
	}

	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}

	public String getThings() {
		return things;
	}

	public void setThings(String things) {
		this.things = things;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "DailyRecord [id=" + id + ", dayTime=" + dayTime + ", things=" + things + ", descript=" + descript
				+ ", count=" + count + ", units=" + units + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
