package FileIO_Exceptions_Sorting_HashMap;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class EinwohnerManager {
    private String path;

    public EinwohnerManager(String path) {
        this.path = path;
    }


    public ArrayList<Einwohner> load() throws DataFileException {
        ArrayList<Einwohner> Einwohner;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Einwohner = new ArrayList<>();
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                Einwohner einwohner = new Einwohner(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]));
                Einwohner.add(einwohner);

            }
        } catch (FileNotFoundException e) {
            throw new DataFileException(e);
        } catch (IOException e) {
            throw new DataFileException(e);
        }
//        test
//        Collections.sort(Einwohner,new yearofBirthdescComparator());

        return Einwohner;
    }



}
