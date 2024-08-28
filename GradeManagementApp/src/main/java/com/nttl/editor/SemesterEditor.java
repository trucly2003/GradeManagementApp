package com.nttl.editor;

/**
 *
 * @author Ly Nguyen
 */
import com.nttl.service.SemesterService;
import com.nttl.pojo.Semester;
import com.nttl.pojo.User;
import com.nttl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.beans.PropertyEditorSupport;

@Component
public class SemesterEditor extends PropertyEditorSupport {

    @Autowired
    private SemesterService semesterService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null && !text.isEmpty()) {
            Integer semesterId = Integer.parseInt(text);
            Semester semester = semesterService.getSemesterById(semesterId);
            setValue(semester);
        }
    }
}
