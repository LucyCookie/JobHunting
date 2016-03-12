import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qiqu on 2/21/16.
 */
public class Sort {
    public int[] zigzag(int[] noOrder) {
        Arrays.sort(noOrder);
        int i = 0, j = noOrder.length - 1;
        int[] sorted = new int[j + 1];
        while (i < j) {
            sorted[2 * i] = noOrder[j];
            sorted[2 * i + 1] = noOrder[i];
            i++;
            j--;
        }
        if (i == j) sorted[2 * i] = noOrder[i];
        return sorted;
    }

    public int[] merge(int[] a, int[] b) {
        int la = a.length, lb = b.length, i = 0, j = 0, cur = 0;
        int[] merged = new int[la + lb];
        while (i < la && j < lb) {
            if (a[i] < b[j]) {
                merged[cur] = a[i];
                i++;
            } else {
                merged[cur] = b[j];
                j++;
            }
            cur++;
        }
        if (i == la) System.arraycopy(b, j, merged, cur, lb - j);
        else System.arraycopy(a, i, merged, cur, la - i);
        return merged;
    }

    public Company[] sort(Company[] companies) {
        Arrays.sort(companies, new Comparator<Company>() {
            @Override
            public int compare(Company o1, Company o2) {
                if (o1.rate == o2.rate) return o1.order - o2.order;
                return o2.rate - o1.rate;
            }
        });
        return companies;
    }

    static class Company {
        int id, rate, order;

        public Company(int id, int rate, int order) {
            this.id = id;
            this.rate = rate;
        }
    }
}
