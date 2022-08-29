package view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.JavaClazz;
import model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfView extends AbstractPdfView{
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws DocumentException {
        JavaClazz clazz = (JavaClazz) map.get("clazzObj");
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {2.0f,3.0f,1.5f});
        table.setSpacingBefore(10);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.CYAN);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        PdfPCell cell2 = new PdfPCell();
        cell2.setBackgroundColor(BaseColor.CYAN);
        cell2.setPadding(5);
        cell2.setPhrase(new Phrase("NAME", font));
        table.addCell(cell2);

        PdfPCell cell3 = new PdfPCell();
        cell3.setBackgroundColor(BaseColor.CYAN);
        cell3.setPadding(5);
        cell3.setPhrase(new Phrase("AGE", font));
        table.addCell(cell3);

        table.completeRow();

        for (Student student: clazz.getStudents()) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(String.valueOf(student.getName()));
            table.addCell(String.valueOf(student.getAge()));
            table.completeRow();
        }

        document.add(table);
    }
}
