package entites;

import java.util.HashSet;
import java.util.Set;

/**
 * Stu entity. @author MyEclipse Persistence Tools
 */

public class Stu implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private String stuName;
	private String stuPassword;
	private Integer stuAge;

	// Constructors

	/** default constructor */
	public Stu() {
	}

	public Stu(String stuName, String stuPassword, Integer stuAge) {
		this.stuName = stuName;
		this.stuPassword = stuPassword;
		this.stuAge = stuAge;
	}

	public Stu(Integer stuId, String stuName, String stuPassword, Integer stuAge) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPassword = stuPassword;
		this.stuAge = stuAge;
	}

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPassword() {
		return this.stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public Integer getStuAge() {
		return this.stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

}