package chenweipan.journal.web;

public class JournalRequest {

	String dayTime;

	String thing;

	String descript;

	String unit;

	Integer count;

	String start;

	String end;

	public String getDayTime() {
		return dayTime;
	}

	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "JournalRequest [dayTime=" + dayTime + ", thing=" + thing + ", descript=" + descript + ", unit=" + unit
				+ ", count=" + count + ", start=" + start + ", end=" + end + "]";
	}
}
