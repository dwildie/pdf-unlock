package com.wildie;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.IOException;

/**
 */
public class PDFUnlock {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            usage();
            return;
        }

        File src = new File(args[0]);
        if (!src.exists()) {
            System.out.printf("PDF file %s does not exist\n", src.getPath());
            return;
        }

        File dst = new File(args[1]);
        if (!dst.getAbsoluteFile().getParentFile().exists()) {
            System.out.printf("Output directory %s does not exist\n", dst.getPath());
            return;
        }

        new PdfDocument(new PdfReader(src).setUnethicalReading(true), new PdfWriter(dst)).close();
    }

    protected static void usage() {
        System.out.println("Usage: java -jar pdf-unlock-1.1.jar <locked.pdf> <unlocked.pdf>");
    }
}
