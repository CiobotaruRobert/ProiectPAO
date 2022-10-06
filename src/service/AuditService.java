package service;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService {

    public static void write_logs(String nume_actiune) {
        File file = new File("C:/Users/Robert/IdeaProjects/ProiectPAO/audit.csv");
        try {
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            DateFormat df = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
            Date date = new Date();
            String data = df.format(date);
            String[] linie = {nume_actiune,data};
            writer.writeNext(linie);
            writer.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}
