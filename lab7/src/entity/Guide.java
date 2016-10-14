package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guide {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String guideNumber;
	private String guideName;
	private long numberOfPages;
	
	public Guide() {		
	}
	
	public Guide(String guideNumber, String guideName, long numberOfPages){
		this.guideNumber = guideNumber;
		this.guideName = guideName;
		this.numberOfPages = numberOfPages;		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGuideNumber() {
		return guideNumber;
	}
	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
	public long getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(long numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	
	
}
