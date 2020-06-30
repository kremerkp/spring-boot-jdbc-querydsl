package lu.eyet.dev.jdbcsandbox.jdbcsandbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import lu.eyet.dev.jdbcsandbox.model.Pet;
import lu.eyet.dev.jdbcsandbox.repository.PetRepository;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@RunWith(SpringRunner.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JasperReportServiceTest {

    @Autowired
    private PetRepository petRepository;

    @Test
    public void jdbcTest() throws FileNotFoundException, JRException {
        testReport();
    }

    public void testReport() throws FileNotFoundException, JRException {
        String outputFile = "C:\\sandbox\\spring-boot-jdbc-querydsl\\src\\main\\resources\\generated_documents\\"
                + "pets.pdf";
        List<Pet> petList = new ArrayList<>();
        petRepository.findAll().forEach(petList::add);

        JRBeanCollectionDataSource items = new JRBeanCollectionDataSource(petList);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("PetsDataSet", items);
        File file = ResourceUtils.getFile("classpath:Blank_A4_1.jrxml");
        InputStream input = new FileInputStream(file);
        JasperDesign jd = JRXmlLoader.load(input);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jp, outputFile);

        System.out.println("Report Generated");

    }
}