package beans.realbeans.entity;

import java.sql.Date;
import java.sql.Time;

public class DateTime extends Entity {
	private Date date;
	private Time time;
	
	public DateTime() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
