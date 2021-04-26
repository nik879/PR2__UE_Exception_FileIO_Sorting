package FileIO_Exceptions_Sorting_HashMap;

import java.io.*;
import java.util.*;

public class EinwohnerManager {
    private String path;
    private ArrayList<Einwohner> Einwohner;

    public EinwohnerManager(String path) {
        this.path = path;
    }


    public ArrayList<Einwohner> load() throws DataFileException {
//        ArrayList<Einwohner> Einwohner;
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

    public HashMap<String, List> getAllNamenByBundesland() {
        HashMap<String, List> NamenbyBundesland = new HashMap<>();
        List<String> EinwohnerNamen;

        for (FileIO_Exceptions_Sorting_HashMap.Einwohner einwohner : Einwohner) {
           EinwohnerNamen = new ArrayList<>();
            if (NamenbyBundesland.containsKey(einwohner.getBundesland())) {
                EinwohnerNamen = NamenbyBundesland.get(einwohner.getBundesland());
                EinwohnerNamen.add(einwohner.getName());
                NamenbyBundesland.put(einwohner.getBundesland(), EinwohnerNamen);
            } else {
                EinwohnerNamen.add(einwohner.getName());
                NamenbyBundesland.put(einwohner.getBundesland(), EinwohnerNamen);
            }

        }

        return NamenbyBundesland;

    }

    public HashMap<String, Integer> getAvgAlterByBundesland() {
//        HashMap<String, Integer> AvgAlterByBundesland = new HashMap<>();
//        Integer Alter;
//        for (FileIO_Exceptions_Sorting_HashMap.Einwohner einwohner : Einwohner) {
//            Alter = 0;
//            if (AvgAlterByBundesland.containsKey(einwohner.getBundesland())) {
//                Alter =AvgAlterByBundesland.get(einwohner.getBundesland()) ;
//
//            }
//        }

        HashMap<String, Integer> CountperBundesland = new HashMap<>();;
        for (FileIO_Exceptions_Sorting_HashMap.Einwohner einwohner : Einwohner) {

            if (CountperBundesland.containsKey(einwohner.getBundesland())) {
                CountperBundesland.put(einwohner.getBundesland(), CountperBundesland.get(einwohner.getBundesland()) + 1);
            } else {
                CountperBundesland.put(einwohner.getBundesland(), 1);
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : CountperBundesland.entrySet()) {
            System.out.println(stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue());
        }

        HashMap<String, Integer> AlterperBundesland = new HashMap<>();
        for (FileIO_Exceptions_Sorting_HashMap.Einwohner einwohner : Einwohner) {
            Integer value = 0;
            if (AlterperBundesland.containsKey(einwohner.getBundesland())) {
                value = AlterperBundesland.get(einwohner.getBundesland()) + (2021 - einwohner.getGeburtsjahr());
                AlterperBundesland.put(einwohner.getBundesland(), value);
            } else {
                AlterperBundesland.put(einwohner.getBundesland(), 2021 - einwohner.getGeburtsjahr());
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : AlterperBundesland.entrySet()) {
            System.out.println(stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue());
        }
        HashMap<String, Integer> Result = new HashMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : AlterperBundesland.entrySet()) {
            Result.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue() / CountperBundesland.get(stringIntegerEntry.getKey()));
        }

        return Result;

        //zum testen
//        HashMap<String, Integer> Result = new HashMap<>();
//        Result.put("Test", 1);
//        return Result;
    }


}
