package com.guvenpanjur.guvenpanjur.service.Impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;


@Service
public class CreatePdfFileService {

    public void createPdf() throws IOException {
        File htmlFile = new File("src/main/resources/templates/customers.html");
        Document doc = Jsoup.parse(htmlFile,"UTF-8");
        doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        try{
            OutputStream os = new FileOutputStream("src/main/resources/static/pdf/output.pdf");
            ITextRenderer renderer = new ITextRenderer();
            SharedContext context = renderer.getSharedContext();
            context.setPrint(true);
            context.setInteractive(false);
            String baseUrl = FileSystems.getDefault().getPath("src/main/resources/templates/").toUri()
                    .toURL().toString();
            renderer.setDocumentFromString(doc.html(), baseUrl);
            renderer.layout();
            renderer.createPDF(os);
            System.out.println("done");
        }catch (Exception e){

        }
    }
}
