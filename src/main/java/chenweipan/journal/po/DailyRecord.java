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

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "descript")
	private String descript;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "sport_id")
	private Integer sportId;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSportId() {
		return sportId;
	}

	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}

	@Override
	public String toString() {
		return "DailyRecord{" +
				"id=" + id +
				", dayTime='" + dayTime + '\'' +
				", title='" + title + '\'' +
				", descript='" + descript + '\'' +
				", userId=" + userId +
				", sportId=" + sportId +
				'}';
	}
}
