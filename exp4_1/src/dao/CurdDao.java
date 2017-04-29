package dao;

import java.util.List;

import entites.Stu;

public interface CurdDao
{
	public String Login(String name, String password);
	
	public String Insert(Stu stu);
	
	public String Delete(Stu stu);
	
	public List<Stu> GetAllStuIndo();
	
	public String Updata(Stu stu);
	
	public Stu GetStuById(Integer id);
}
