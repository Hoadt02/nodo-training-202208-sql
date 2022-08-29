package controller;

import DAO.StudentDAO;
import model.JavaClazz;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    StudentDAO studentDAO;

    @RequestMapping(value = "/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody JavaClazz viewInXML(){
        return new JavaClazz(studentDAO.list());
    }

    @RequestMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JavaClazz viewInJSON(){
        return new JavaClazz(studentDAO.list());
    }

    @GetMapping("/xslt")
    public ModelAndView viewXSLT() throws JAXBException, ParserConfigurationException, IOException, SAXException {
        JavaClazz clazz = new JavaClazz(studentDAO.list());
        ModelAndView model = new ModelAndView("ClazzView");
        model.getModelMap().put("data",XSLTUtils.clazzToDomSource(clazz));
        return model;
    }

    @GetMapping("/excel")
    public ModelAndView viewExcel(){
        JavaClazz clazz = new JavaClazz(studentDAO.list());
        ModelAndView model = new ModelAndView("excelView");
        model.getModelMap().put("clazzObj",clazz);
        return model;
    }

    @RequestMapping(value = "/pdf",produces = "application/pdf")
    public ModelAndView viewPdf(){
        JavaClazz clazz = new JavaClazz(studentDAO.list());
        ModelAndView model = new ModelAndView("pdfView");
        model.getModelMap().put("clazzObj",clazz);
        return model;
    }

    @RequestMapping(value = "/report", produces = "application/pdf")
    public ModelAndView viewReport(){
        JRDataSource dataSource = new JRBeanArrayDataSource(studentDAO.list().toArray());
        ModelAndView model = new ModelAndView("pdfReport");
        model.addObject("dataSource", dataSource);
        return model;
    }
}
