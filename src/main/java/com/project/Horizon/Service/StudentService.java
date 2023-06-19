package com.project.Horizon.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.project.Horizon.Model.Student;
import com.project.Horizon.Repository.StudentRepo;

import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class StudentService {
    
    @Autowired
    private StudentRepo repo;

    public List<Student> getStudents() {
        return repo.findAll();
    }
    public Student getStudentByUsername(String username) {
        return repo.findByUsername(username).get();
    }

    public void save(Student student){
        repo.save(student);
    }
    public Student deleteByPassword(String password){
        repo.deleteByPassword(password);
        return null;
      
    }
    /*public String exportReport(String reportFormat){
      List<Student> students = repo.findAll();
      File file = ResourceUtils.getFile("classpath:students.jrxml");
      JasperReport report = new JasperCompileManager.compileReport(file.getAbsolutePath());
      JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(students);
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("Created by Edward", parameters);
      JasperPrint print = JasperFillManager.fillReport(report, parameters, datasource);
      if(reportFormat.equalsIgnoreCase("html")){
        JasperExportManager.exportReportToHtmlFile(print,"C:/Users/PC/OneDrive/Documents/jasperReports");
      }
      if(reportFormat.equalsIgnoreCase("pdf")){
        JasperExportManager.exportReportToPdfFile(print,"C:/Users/PC/OneDrive/Documents/jasperReports");
      }
      return "";
    }*/
   

   
}
