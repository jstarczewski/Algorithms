import java.util.Random;

public class MergeSortNoRecur
{
    private static int[] extra;
    private static int[] main;

    public static void Sort(int[] v, int n)
    {
        int[] temp;
        extra = new int[n];
        main = v;
        int i;
        for (int j = 1; j <= n; j *= 2) // j - wielkość posortowanych podtablic: 1,2,4,8,...
        {
            for (i = 0; i <= n - j; i += 2 * j) // złączanie dwóch podtablic(pierwsza ma poczatkowy indeks i, druga i+j,trzecia i+2j)
                Merge(i, i + j - 1, n - 1 < i + 2 * j - 1 ? n - 1 : i + 2 * j - 1);
            if (i < n - 1) //gdy liczba modułów jest nieparzysta pozostanie jeden nieposortowany
                Merge(i, n - 1, n - 1);
            //jest to potrzebne ponieważ złączalismy w kolekcji "extra"
            temp = main;
            main = extra;
            extra = temp;
        }
        if (main != v) //jezeli zamienilismy podtablice extra z main nieparzysta ilosc razy
            for (i = 0; i < n; i++)
                v[i] = main[i];

    }

    private static void Merge(int begin, int middle, int end)
    {
        //zlaczanie podtablic z "main" do "extra"
        int i = begin;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end)
            if (main[i] < main[j])
                extra[begin + k++] = main[i++];
            else
                extra[begin + k++] = main[j++];
        while (i <= middle)
            extra[begin + k++] = main[i++];
        while (j <= end)
            extra[begin + k++] = main[j++];
    }
    public static void main(String [] args){
        Random r = new Random();
        int n = 50;
        int max = 100;
        int [] v = new int [n];

        for(int i = 0; i < n; i++)
            v[i] = r.nextInt() % max;

        Sort(v,n);

        for(int x : v)
            System.out.print(x + ", ");
    }
}
