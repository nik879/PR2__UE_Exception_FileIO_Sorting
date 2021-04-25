package FileIO_Exceptions_Sorting_HashMap;

import java.util.Comparator;

public class yearofBirthdescComparator implements Comparator<Einwohner> {

    @Override
    public int compare(Einwohner o1, Einwohner o2) {
        return Integer.compare(o2.getGeburtsjahr(), o1.getGeburtsjahr());
    }
}
