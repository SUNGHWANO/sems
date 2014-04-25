package controls;

import java.util.Map;

import annotation.Component;
import vo.SubjectVo;
import dao.SubjectDao;

@Component("/subject/insert.bit")
public class SubjectInsertControl implements PageController{
	SubjectDao subjectDao;
	
	public void setSubjectDao(SubjectDao subjectDao) {
	  this.subjectDao = subjectDao;
  }
	
	
	@Override
  public String execute(Map<String, Object> model) {
	
		
		if(model.get("title") == null){
			return "/subject/form.jsp";
		}else{
			
			try{
				
			SubjectVo subject = new SubjectVo();
			subject.setTitle((String)model.get("title"));
			subject.setDescription((String)model.get("description"));
			subjectDao.insert(subject);
			model.put("subject", subject);
			return "/subject/insert.jsp";
			
			}catch(Throwable ex){
				throw new Error(ex);
			}
		}
  }
}
