package publicadministration;

import data.DocPath;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class PDFDocument {

    // Represents a PDF document

    private final Date creatDate;
    private DocPath path;
    private final File file;
    private final static String defaultPath = "defaultPath.pdf";

    public PDFDocument() {
        // Initializes attributes and emulates the document download at a default path
        this.creatDate = new Date();
        this.path = new DocPath(defaultPath);
        this.file = new File(path.getPath());
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public DocPath getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }

    public String toString() {
        return "PDFDocument [creatDate=" + creatDate + ", path=" + path + "]";
    }

    public void moveDoc (DocPath destPath) throws IOException {
        // Moves the document to a new path
        Path source = Paths.get(path.getPath());
        Path destination = Paths.get(destPath.getPath());
        Files.move(source, destination);
        this.path = destPath;
    }

    public void openDoc (DocPath path) throws IOException {
        // Opens the document at the path indicated
        File file = new File(path.getPath());
        Desktop.getDesktop().open(file);
    }
}