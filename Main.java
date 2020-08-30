

import java.util.*;

public class Main {

    public Owoc[] koszyk = new Owoc[20];

    public static void main(String[] args) {
        Random rand = new Random();
        Owoc[] koszyk = new Owoc[20];

        for (int i = 0; i < 20; i++) {
            koszyk[i] = new Owoc();
            koszyk[i].kaliber = rand.nextInt(10);
            koszyk[i].waga = rand.nextInt(10) * 1.1;
            System.out.println(koszyk[i].kaliber);
            System.out.println(koszyk[i].waga);

        }
        mySort(koszyk);

    }

    public static Owoc[][][] mySort(Owoc[] koszyk) {
        Owoc[][][] toRet = new Owoc[3][koszyk.length][koszyk.length];
        Owoc[] bubSortArr = koszyk.clone();

        for (int i = 0; i < bubSortArr.length - 1; i++) {
            for (int j = 0; j < bubSortArr.length - i - 1; j++)
                if (bubSortArr[j].kaliber > bubSortArr[j + 1].kaliber
                        || (bubSortArr[j].kaliber == bubSortArr[j + 1].kaliber
                                && bubSortArr[j].waga > bubSortArr[j + 1].waga)) {
                    Owoc temp = bubSortArr[j];
                    bubSortArr[j] = bubSortArr[j + 1];
                    bubSortArr[j + 1] = temp;

                }
            toRet[0][i] = bubSortArr.clone();
        }
        Owoc[] selectionSort = koszyk.clone();
        for (int i = 0; i < selectionSort.length - 1; i++) {

            for (int j = i + 1; j < selectionSort.length; j++)
                if (selectionSort[j].kaliber < selectionSort[i].kaliber
                        || (selectionSort[j].kaliber == selectionSort[i].kaliber
                                && selectionSort[j].waga > selectionSort[i].waga)) {

                    Owoc temp = selectionSort[j];
                    selectionSort[j] = selectionSort[i];
                    selectionSort[i] = temp;
                }
            toRet[1][i] = selectionSort.clone();

        }

       
        Owoc[] insertionSort = koszyk.clone();
        for (int i = 1; i < insertionSort.length; ++i) {
            Owoc key = insertionSort[i];
            int j = i - 1;

            while (j >= 0 && (insertionSort[j].kaliber > key.kaliber
                    || (insertionSort[j].kaliber == key.kaliber && insertionSort[j].waga > key.waga))) {
                insertionSort[j + 1] = insertionSort[j];
                j = j - 1;
            }
            insertionSort[j + 1] = key;
            toRet[2][i] = insertionSort.clone();
        }
        for (int v = 1; v < toRet.length; v++) {
            for (int w = 1; w < toRet[v].length; w++) {
                for (int e = 1; e < toRet[v][w].length; e++) {
                    System.out.println(toRet[v][w][e]);
                }
            }

        }

        return toRet;

    }

}

class Owoc {
    int kaliber;
    double waga;

    @Override
    public String toString() {
        return "Owoc+" + kaliber + " " + waga;
    }

}
