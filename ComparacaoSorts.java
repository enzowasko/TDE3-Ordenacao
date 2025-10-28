public class ComparacaoSorts {

    static class Resultado {
        int trocas;
        int iteracoes;
        Resultado(int t, int i) { trocas = t; iteracoes = i; }
    }

    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        
        final int N = 20;

        System.out.println("\n===== Vetor 1 (Aleatório) - N=" + N + " =====");
        testar(vetor1, N);

        System.out.println("\n===== Vetor 2 (Ordenado) - N=" + N + " =====");
        testar(vetor2, N);

        System.out.println("\n===== Vetor 3 (Decrescente) - N=" + N + " =====");
        testar(vetor3, N);
    }

    static void testar(int[] vetor, int n) {
        comparar("Comb Sort", vetor, n, ComparacaoSorts::combSort);
        comparar("Gnome Sort", vetor, n, ComparacaoSorts::gnomeSort);
        comparar("Bubble Sort (flag)", vetor, n, ComparacaoSorts::bubbleSortFlag);
        comparar("Selection Sort", vetor, n, ComparacaoSorts::selectionSort);
        comparar("Cocktail Sort", vetor, n, ComparacaoSorts::cocktailSort);
        comparar("Bucket Sort", vetor, n, ComparacaoSorts::bucketSort);
    }

    interface Metodo {
        Resultado executar(int[] v, int n);
    }

    static void comparar(String nome, int[] vetor, int n, Metodo metodo) {
        int[] copia = copiarVetor(vetor, n);
        Resultado r = metodo.executar(copia, n);
        System.out.printf("%-20s -> Trocas: %4d | Iterações: %6d%n", nome, r.trocas, r.iteracoes);
    }

    static int[] copiarVetor(int[] v, int n) {
        int[] novo = new int[n];
        for (int i = 0; i < n; i++) novo[i] = v[i];
        return novo;
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    static Resultado combSort(int[] v, int n) {
        int gap = n;
        boolean trocou = true;
        int trocas = 0, iter = 0;
        final double FATOR = 1.3;

        while (gap > 1 || trocou) {
            gap = (int)(gap / FATOR);
            if (gap < 1) gap = 1;
            trocou = false;
            for (int i = 0; i + gap < n; i++) {
                iter++;
                if (v[i] > v[i + gap]) {
                    swap(v, i, i + gap);
                    trocas++;
                    trocou = true;
                }
            }
        }
        return new Resultado(trocas, iter);
    }

    static Resultado gnomeSort(int[] v, int n) {
        int pos = 0, trocas = 0, iter = 0;
        while (pos < n) {
            iter++;
            if (pos == 0 || v[pos] >= v[pos - 1]) {
                pos++;
            } else {
                swap(v, pos, pos - 1);
                pos--;
                trocas++;
            }
        }
        return new Resultado(trocas, iter);
    }

    static Resultado bubbleSortFlag(int[] v, int n) {
        int trocas = 0, iter = 0;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                iter++;
                if (v[j] > v[j + 1]) {
                    swap(v, j, j + 1);
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
        return new Resultado(trocas, iter);
    }

    static Resultado selectionSort(int[] v, int n) {
        int trocas = 0, iter = 0;
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                iter++;
                if (v[j] < v[menor]) menor = j;
            }
            if (menor != i) {
                swap(v, i, menor);
                trocas++;
            }
        }
        return new Resultado(trocas, iter);
    }

    static Resultado cocktailSort(int[] v, int n) {
        int inicio = 0, fim = n - 1;
        boolean trocou = true;
        int trocas = 0, iter = 0;

        while (trocou) {
            trocou = false;
            for (int i = inicio; i < fim; i++) {
                iter++;
                if (v[i] > v[i + 1]) {
                    swap(v, i, i + 1);
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;

            trocou = false;
            fim--;
            for (int i = fim - 1; i >= inicio; i--) {
                iter++;
                if (v[i] > v[i + 1]) {
                    swap(v, i, i + 1);
                    trocas++;
                    trocou = true;
                }
            }
            inicio++;
        }
        return new Resultado(trocas, iter);
    }

    static Resultado bucketSort(int[] v, int n) {
        int trocas = 0, iter = 0;

        if (n <= 1) return new Resultado(0, 0);

        int min = v[0], max = v[0];
        for (int i = 1; i < n; i++) {
            iter++;
            if (v[i] < min) min = v[i];
            if (v[i] > max) max = v[i];
        }

        final int numBuckets = 4;
        
        int[][] buckets = new int[numBuckets][n];
        int[] contadores = new int[numBuckets];
        int range = max - min + 1;

        for (int i = 0; i < n; i++) {
            iter++;
            int idx = 0;
            if (range > 0) {
                 idx = (v[i] - min) * numBuckets / range;
            }
            
            if (idx >= numBuckets) idx = numBuckets - 1;

            buckets[idx][contadores[idx]++] = v[i];
        }

        int pos = 0;
        for (int b = 0; b < numBuckets; b++) {
            int tamanhoBalde = contadores[b];
            
            for (int i = 1; i < tamanhoBalde; i++) {
                int chave = buckets[b][i];
                int j = i - 1;
                while (j >= 0 && buckets[b][j] > chave) {
                    buckets[b][j + 1] = buckets[b][j];
                    j--;
                    trocas++; 
                    iter++;
                }
                buckets[b][j + 1] = chave;
                if (j + 1 != i) trocas++; 
            }
            
            for (int i = 0; i < tamanhoBalde; i++) {
                v[pos++] = buckets[b][i];
                iter++;
            }
        }
        
        return new Resultado(trocas, iter);
    }
}