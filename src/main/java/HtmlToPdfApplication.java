import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.layout.font.FontProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmlToPdfApplication {

    public static final String[] FONTS = {
            "/home/iface/clients/finalitix/pdf-example/src/main/resources/font/Adhawin-Tamil Regular.ttf",
            "/home/iface/clients/finalitix/pdf-example/src/main/resources/font/arialuni.ttf",
            "/home/iface/clients/finalitix/pdf-example/src/main/resources/font/cyrillic.ttf",
            "/home/iface/clients/finalitix/pdf-example/src/main/resources/font/TAM-007.TTF",
            "/home/iface/clients/finalitix/pdf-example/src/main/resources/font/freesans.ttf",
            "/home/iface/clients/finalitix/pdf-example/src/main/resources/font/ARIALUNI.TTF"
    };

    public static void main(String[] args) {
        try {
            ConverterProperties properties = new ConverterProperties();
            FontProvider fontProvider = new DefaultFontProvider(false, false, false);
            for (String font : FONTS) {
                FontProgram fontProgram = FontProgramFactory.createFont(font);
                fontProvider.addFont(fontProgram);
                fontProvider.addFont(fontProgram);
            }
            properties.setFontProvider(fontProvider);
            String inputFile = "/home/iface/clients/finalitix/pdf-example/src/main/resources/templates/testing.html";
            String outputPdfFile = "/home/iface/clients/finalitix/pdf-example" + File.separator + "thymeleaf.pdf";
            HtmlConverter.convertToPdf(new FileInputStream(inputFile),
                    new FileOutputStream(outputPdfFile), properties);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
