package pl.klimas7.learn.comparator;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReleaseVersionSort {

    public static void main(String... args) {
        List<String> releaseVersionList = Arrays.asList("r9.2", "r9.2.1", "r9.4", "main", "r9.1", "r9.3", "r9.3.1", "feature");

        releaseVersionList.sort(new VersionComparatorBad());
        System.out.println(releaseVersionList);

        releaseVersionList.sort(new VersionComparatorGood());
        System.out.println(releaseVersionList);
    }

    private static class VersionComparatorBad implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return "main".equals(o2) ? 1 : o2.compareTo(o1);
        }
        // W tym wypadku komparator jest nie deterministyczny
    }

    private static class VersionComparatorGood implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if ("main".equals(o2)){
                return 1;
            }
            else if ("main".equals(o1)){
                return -1;
            }
            return o2.compareTo(o1);
        }
        // W tym wypadku komparator jest deterministyczny
    }
}



/*
Programista pisał komparator wersji swojej aplikacji.
dla dowolnie zdefiniowanej listy wersji apikacji np ["r9.2", "main", "r9.1", "r9.3", "r9.3.1", "feature"]

chciał uzyskać rezultat że main bedzie zawsze pierwsze a reszta posortowana w kolejności malejącej
czyli w tym przypadku chciał uzyskać wynik
[main, r9.3.1, r9.3, r9.2, r9.1, feature]

Co zostanie wypisane na konsole?
Czy należy poprawić komparator jeśli tak to co trzeba zmienić

 */
