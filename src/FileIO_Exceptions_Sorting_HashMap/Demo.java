package FileIO_Exceptions_Sorting_HashMap;

import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) {
        EinwohnerManager em = new EinwohnerManager("C:\\Users\\nikikachelmaier\\Downloads" +
                "\\testdata-einwohner.csv");
        try {
            ArrayList<Einwohner> einwohner = em.load();
            System.out.println(einwohner);
            System.out.println("\n"+"\n"+"\n"+"\n");
            Collections.sort(einwohner, new yearofBirthdescComparator());
            System.out.println(einwohner);
        } catch (DataFileException e) {
            e.printStackTrace();
        }
    }
}
