package entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String guideNumber;
	private String guideName;
	private long numberOfPages;
	
	@OneToMany(mappedBy="guide", cascade={CascadeType.PERSIST})
	private Set<Student> students = new HashSet<Student>();	
	
	

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

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
	public void addStudent(Student student) {
		students.add(student);
		student.setGuide(this);
	}
	
	
}
