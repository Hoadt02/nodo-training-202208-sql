package controller;

import DAO.StudentDAO;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

@Controller
@RequestMapping("/hello")
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("student/student_form", "command", new Student());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result) {
        ModelAndView mv;
        if (result.hasErrors()) {
            mv = new ModelAndView("student/student_form", "command", student);
            mv.setViewName("student/student_form");
            mv.addObject("errors", result);
            return mv;
        }
        if (student.getId() > 0) {
            studentDAO.update(student);
            return new ModelAndView("redirect:/hello/list");
        } else {
            studentDAO.insert(student);
            return new ModelAndView("redirect:/hello/list");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listStudents(@RequestParam("q") Optional<String> query) {
        ModelAndView model = new ModelAndView();
        model.setViewName("student/student_list");
        if (!query.isPresent()) model.addObject("students", studentDAO.list());
        if (query.isPresent()) model.addObject("students", studentDAO.search(query.get()));
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        studentDAO.delete(id);
        return "redirect:/hello/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        Student student = studentDAO.get(id);
        return new ModelAndView("student/student_form", "command", student);
    }

    @RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
    public @ResponseBody Student viewJson(@PathVariable("id") Integer id) {
        return studentDAO.get(id);
    }

    @RequestMapping(value = "/avatar/save/{id}", method = RequestMethod.POST)
    public String handlerFormUpload(@RequestParam("file") MultipartFile file,
                                    @PathVariable("id") Integer id,
                                    HttpServletRequest request) throws IOException {
        if (file.isEmpty()) return "student/student_error";

        byte[] bytes = file.getBytes();
        System.out.println("found ---> " + bytes.length);
        Path avatarFile = getImageFile(request, id);
        Files.write(avatarFile, file.getBytes(), StandardOpenOption.CREATE);

        System.out.println(avatarFile);
        return "redirect:/hello/list";
    }

    private Path getImageFile(HttpServletRequest request, Integer id) {
        ServletContext servletContext = request.getSession().getServletContext();
        String realPath = servletContext.getRealPath("/");
        File folder = new File(realPath + File.separator + "avatar");
        if (!folder.exists()) folder.mkdirs();

        return Paths.get(folder.getAbsolutePath() + File.separator + id + ".jpg");
    }

    @RequestMapping(value = "/avatar/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id, HttpServletRequest request) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        if (id != null) {
            Path avatarPath = getImageFile(request, id);
            byteOut.write(Files.readAllBytes(avatarPath));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(byteOut.toByteArray(), headers, HttpStatus.CREATED);
    }
}

