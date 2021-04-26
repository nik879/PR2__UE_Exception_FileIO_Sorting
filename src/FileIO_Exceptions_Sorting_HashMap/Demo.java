package FileIO_Exceptions_Sorting_HashMap;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        EinwohnerManager em = new EinwohnerManager("C:\\Users\\nikik\\Downloads" +
                "\\testdata-einwohner.csv");
        try {
            ArrayList<Einwohner> einwohner = em.load();
//            System.out.println(einwohner);
//            System.out.println("\n"+"\n"+"\n"+"\n");
//            Collections.sort(einwohner, new yearofBirthdescComparator());
//            Collections.sort(einwohner);
//            System.out.println(einwohner);
//            HashMap<String, List> Result = em.getAllNamenByBundesland();
//            for (Map.Entry<String, List> stringListEntry : Result.entrySet()) {
//                System.out.println(stringListEntry.getKey()+"="+stringListEntry.getValue());
//            }
            //last statement verified
            HashMap<String, Integer> Result = em.getAvgAlterByBundesland();

            for (Map.Entry<String, Integer> e : Result.entrySet()) {
                System.out.println(e.getKey() + "=" + e.getValue());
            }
        } catch (DataFileException e) {
            e.printStackTrace();
        }
    }
}
