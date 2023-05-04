import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class App {
    static Ordenate ordenate = new Ordenate();
    static Scanner s = new Scanner(System.in);
    static String pathInputFile = "./jogadores.txt";

    // static String pathInputFile = "S:\\Users\\José
    // Victor\\dev\\algorithm-and-data-structures-II\\nba\\ordenacao\\src\\tmp\\jogadores.txt";
    // static String pathInputFile =
    // "/home/jose/coding/algorithm-and-data-structures-II/nba/ordenacao/src/tmp/jogadores.txt";
    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");

        // lê os dados dos jogadores
        Jogador[] jogadores = lerJogadores();

        // lê as ids dos jogadores para serem ordenados
        String[] ids = readUserEntry();

        // cria a fila com os jogadores de ids entrados pelo usuário
        PlayersQueue queue = new PlayersQueue(ids);

        Jogador[] orderedJogadores;
        orderedJogadores = new Jogador[ids.length];

        s.close();

        // Método BubbleSort
        ordenate.startMeasure("bolha");
        orderedJogadores = ordenate.bubbleSort(orderedJogadores);
        for (Jogador jogador : orderedJogadores) {
            jogador.imprimir();
        }

        // Método SelectionSort
        // ordenate.startMeasure("selecao");
        // orderedJogadores = ordenate.selectionSort(orderedJogadores);
        // for (Jogador jogador : orderedJogadores) {
        // jogador.imprimir();
        // }

        // Método InsertionSort
        // ordenate.startMeasure("insercao");
        // orderedJogadores = ordenate.insertionSort(orderedJogadores);
        // for (Jogador jogador : orderedJogadores) {
        // jogador.imprimir();
        // }

        // Método HeapSort
        // ordenate.startMeasure("heapsort");
        // orderedJogadores = ordenate.heapSort(orderedJogadores);
        // for (Jogador jogador : orderedJogadores) {
        // jogador.imprimir();
        // }

        // Método MergeSort
        // ordenate.startMeasure("mergesort");
        // orderedJogadores = ordenate.mergeSort(orderedJogadores);
        // for (Jogador jogador : orderedJogadores) {
        // jogador.imprimir();
        // }

        // Método QuickSort
        // ordenate.startMeasure("quicksort");
        // orderedJogadores = ordenate.quickSort(orderedJogadores);
        // for (Jogador jogador : orderedJogadores) {
        // jogador.imprimir();
        // }

        ordenate.finishMeasure();
    }

    private static String[] readUserEntry() {
        String[] ids = new String[0];
        String id = "";

        try {
            id = s.nextLine();
        } catch (Exception e) {
        }

        do {
            ids = Arrays.copyOf(ids, ids.length + 1);
            ids[ids.length - 1] = id;

            try {
                id = s.nextLine();
            } catch (Exception e) {
            }
        } while (!id.equals("FIM") && id.length() > 0);

        return ids;
    }

    public static class Jogador {
        private int id;
        private String nome;
        private int altura;
        private int peso;
        private String universidade;
        private int anoNascimento;
        private String cidadeNascimento;
        private String estadoNascimento;

        // Construtores da classe
        public Jogador() {
        }

        public Jogador(int id, String nm, int altura, int peso, String unv, int aNas,
                String cNas, String eNas) {
            this.id = id;
            this.nome = nm;
            this.altura = altura;
            this.peso = peso;
            this.universidade = unv;
            this.anoNascimento = aNas;
            this.cidadeNascimento = cNas;
            this.estadoNascimento = eNas;
        }

        Jogador(String packet) {
            // MyIO.println("packet"+ packet);
            // if (packet.charAt(0) < 48 || packet.charAt(0) > 57) {
            // return;
            // }

            String[] tokens = packet.split(",", -1);
            // - id do jogador;
            // - nome do jogador;
            // - sua altura;
            // - seu peso;
            // - universidade que o jogador representa;
            // - ano de nascimento do jogador;
            // - nome da cidade em que o jogador nasceu;
            // - estado em que o jogador nasceu.

            try {
                this.id = Integer.parseInt(tokens[0]);
            } catch (Exception e) {
                // handle exception
            }

            try {
                this.nome = tokens[1];
            } catch (Exception e) {
                // handle exception
            }

            try {
                this.altura = Integer.parseInt(tokens[2]);
            } catch (Exception e) {
                // handle exception
            }

            try {
                this.peso = Integer.parseInt(tokens[3]);
            } catch (Exception e) {
                // handle exception
            }

            try {
                this.universidade = tokens[4];
            } catch (Exception e) {
                // handle exception
            }

            try {
                this.anoNascimento = Integer.parseInt(tokens[5]);
            } catch (Exception e) {
                // handle exception
            }

            try {
                this.cidadeNascimento = tokens[6];
            } catch (Exception e) {
                // handle exception
            }

            try {
                this.estadoNascimento = tokens[7];
            } catch (Exception e) {
                // handle exception
            }
        }

        // getters
        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public int getAltura() {
            return altura;
        }

        public int getPeso() {
            return peso;
        }

        public String getUniversidade() {
            return universidade;
        }

        public int getAnoNascimento() {
            return anoNascimento;
        }

        public String getCidadeNascimento() {
            return cidadeNascimento;
        }

        public String getEstadoNascimento() {
            return estadoNascimento;
        }

        // setters
        public void setId(int id) {
            this.id = id;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        public void setUniversidade(String universidade) {
            this.universidade = universidade;
        }

        public void setAnoNascimento(int anoNascimento) {
            this.anoNascimento = anoNascimento;
        }

        public void setCidadeNascimento(String cidadeNascimento) {
            this.cidadeNascimento = cidadeNascimento;
        }

        public void setEstadoNascimento(String estadoNascimento) {
            this.estadoNascimento = estadoNascimento;
        }

        // Outros métodos
        public void imprimir() {
            System.out.print("[" + this.id);

            if (this.nome != null && !this.nome.isEmpty()) {
                System.out.print(" ## " + this.nome);
            } else {
                System.out.print(" ## nao informado");
            }

            if (this.altura != 0.0) {
                System.out.print(" ## " + this.altura);
            } else {
                System.out.print("## nao informado");
            }

            if (this.peso != 0.0) {
                System.out.print(" ## " + this.peso);
            } else {
                System.out.print("## nao informado");
            }

            if (this.anoNascimento != 0) {
                System.out.print(" ## " + this.anoNascimento);
            } else {
                System.out.print(" ## nao informado");
            }

            if (this.universidade != null && !this.universidade.isEmpty()) {
                System.out.print(" ## " + this.universidade);
            } else {
                System.out.print(" ## nao informado");
            }

            if (this.cidadeNascimento != null && !this.cidadeNascimento.isEmpty()) {
                System.out.print(" ## " + this.cidadeNascimento);
            } else {
                System.out.print(" ## nao informado");
            }

            if (this.estadoNascimento != null && !this.estadoNascimento.isEmpty()) {
                System.out.print(" ## " + this.estadoNascimento);
            } else {
                System.out.print(" ## nao informado");
            }

            System.out.println("]");

        }
    }

    private static Jogador[] lerJogadores() {
        // lê os dados dos jogadores e adiciona ao vetor de jogadores
        Jogador[] jogadores = new Jogador[20000];
        int numJogadores = 0;
        ArquivoTextoLeitura readFile = new ArquivoTextoLeitura(pathInputFile);

        String linha = readFile.ler();
        // pula primeira linha
        // linha = readFile.ler();

        do {
            // MyIO.println(linha);
            try {
                Jogador jogador = new Jogador(linha);
                jogadores[numJogadores] = jogador;
            } catch (Exception e) {
            }

            numJogadores++;

            try {
                linha = readFile.ler();
            } catch (Exception e) {
            }
        } while (linha != null && linha.length() > 0);

        readFile.fecharArquivo();

        // cria um novo vetor de jogadores com o tamanho exato do número de jogadores
        // lidos
        Jogador[] jogadoresFinais = new Jogador[numJogadores];
        for (int i = 0; i < numJogadores; i++) {
            jogadoresFinais[i] = jogadores[i];
        }

        return jogadoresFinais;
    }

    private static class ArquivoTextoLeitura {
        private BufferedReader entrada;

        ArquivoTextoLeitura(String nomeArquivo) {
            try {
                entrada = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"));
            } catch (UnsupportedEncodingException excecao) {
                System.out.println(excecao.getMessage());
            } catch (FileNotFoundException excecao) {
                System.out.println("Arquivo nao encontrado");
            }
        }

        public void fecharArquivo() {
            try {
                entrada.close();
            } catch (IOException excecao) {
                System.out.println("Erro no fechamento do arquivo de leitura: " +
                        excecao);
            }
        }

        @SuppressWarnings("finally")
        public String ler() {
            String textoEntrada = null;
            try {
                textoEntrada = entrada.readLine();
            } catch (EOFException excecao) { // Excecao de final de arquivo.
                textoEntrada = null;
            } catch (IOException excecao) {
                System.out.println("Erro de leitura: " + excecao);
                textoEntrada = null;
            } finally {
                return textoEntrada;
            }
        }
    }

    public static class ArquivoTextoEscrita {
        private BufferedWriter saida;

        ArquivoTextoEscrita(String nomeArquivo) {
            try {
                saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nomeArquivo), "UTF-8"));
            } catch (UnsupportedEncodingException excecao) {
                System.out.println(excecao.getMessage());
            } catch (IOException excecao) {
                System.out.println("Erro na abertura do arquivo de escrita: " +
                        excecao);
            }
        }

        public void fecharArquivo() {
            try {
                saida.close();
            } catch (IOException excecao) {
                System.out.println("Erro no fechamento do arquivo de escrita: " +
                        excecao);
            }
        }

        public void escrever(String textoEntrada) {
            try {
                saida.write(textoEntrada);
                saida.newLine();
            } catch (IOException excecao) {
                System.out.println("Erro de entrada/saída " + excecao);
            }
        }
    }

    public static class Ordenate {
        private int comparacoes;
        private int movimentacoes;
        private long timeInicio;
        private long timeDiff;
        private String problemName;

        public String getProblemName() {
            return this.problemName;
        }

        public int getComparacoes() {
            return this.comparacoes;
        }

        public void setComparacoes(int comparacoes) {
            this.comparacoes = comparacoes;
        }

        public int getMovimentacoes() {
            return this.movimentacoes;
        }

        public long getTimeInicio() {
            return this.timeInicio;
        }

        public long getTimeDiff() {
            return this.timeDiff;
        }

        public void setMovimentacoes(int movimentacoes) {
            this.movimentacoes = movimentacoes;
        }

        public void setTimeInicio(long timeInicio) {
            this.timeInicio = timeInicio;
        }

        public void setTimeDiff(long timeDiff) {
            this.timeDiff = timeDiff;
        }

        public void setProblemName(String name) {
            this.problemName = name;
        }

        public void startMeasure(String problem_name) {
            this.comparacoes = 0;
            this.movimentacoes = 0;
            this.timeInicio = System.currentTimeMillis();
            this.problemName = problem_name;
        }

        public void finishMeasure() {
            this.timeDiff = System.currentTimeMillis() - this.timeInicio;

            StringBuilder str = new StringBuilder();

            str.append("796839\t")
                    .append(this.timeDiff + "\t")
                    .append(this.comparacoes + "\t")
                    .append(this.movimentacoes);

            ArquivoTextoEscrita measure = new ArquivoTextoEscrita("796839_" + this.problemName + ".txt");
            try {
                measure.escrever(str.toString());
                measure.fecharArquivo();
            } catch (Exception e) {
                System.err.println("Erro ao criar arquivo de log: " + e.getMessage());
            }
        }

        public void addMove() {
            this.movimentacoes++;
        }

        public void addCompares() {
            this.comparacoes++;
        }

        public static int compare(Jogador j1, Jogador j2) {
            // Verifica se ambos os jogadores não têm cidade de nascimento
            if (j1.getCidadeNascimento().isEmpty() && j2.getCidadeNascimento().isEmpty()) {
                // Compara com base no nome
                ordenate.addCompares();
                return j1.getNome().compareTo(j2.getNome());
            } else {
                // Compara com base na cidade de nascimento
                int cmp = j1.getCidadeNascimento().compareTo(j2.getCidadeNascimento());
                ordenate.addCompares();
                // Se eles tiverem a mesma cidade de nascimento, compara com base no nome
                if (cmp == 0) {
                    cmp = j1.getNome().compareTo(j2.getNome());
                    ordenate.addCompares();
                }
                // Verifica se j1 não tem cidade de nascimento, colocando-o no final da lista
                else if (j1.getCidadeNascimento().isEmpty()) {
                    cmp = 1;
                }
                // Verifica se j2 não tem cidade de nascimento, colocando-o no final da lista
                else if (j2.getCidadeNascimento().isEmpty()) {
                    cmp = -1;
                }
                return cmp;
            }
        }

        public Jogador[] bubbleSort(Jogador[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (compare(arr[j], arr[j + 1]) > 0) {
                        Jogador temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        ordenate.addMove();
                    }
                    ordenate.addCompares();
                }
            }

            return arr;
        }

        public Jogador[] selectionSort(Jogador[] arr) {
            Jogador auxJogador = new Jogador();

            for (int i = 0; i < arr.length; i++) {
                Jogador menor = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    ordenate.addCompares();
                    int compareVal = arr[j].getNome().compareTo(menor.getNome());

                    if (compareVal < 0) {
                        // a < b (lexo)
                        menor = arr[j];

                    }

                    ordenate.addCompares();
                    if (arr[i].getNome() != menor.getNome()) {
                        auxJogador = arr[i];
                        arr[i] = menor;
                        arr[j] = auxJogador;

                        ordenate.addMove();
                    }
                }
            }

            return arr;
        }

        public Jogador[] insertionSort(Jogador[] arr) {
            for (int i = 1; i < arr.length; i++) {
                Jogador temp = arr[i];
                int j = i - 1;

                ordenate.addCompares();
                // faz a ordenação por ano de nascimento
                while (j >= 0 && arr[j].getAnoNascimento() > temp.getAnoNascimento()) {

                    ordenate.addMove();

                    arr[j + 1] = arr[j];
                    j--;
                }

                ordenate.addCompares();
                // caso ano for igual, verifica os nomes
                if (j >= 0 && arr[j].getAnoNascimento() == temp.getAnoNascimento()) {
                    // ordena por ordem alfabética

                    ordenate.addCompares();
                    int cmp = arr[j].getNome().compareToIgnoreCase(temp.getNome());

                    while (j >= 0 && cmp > 0 &&
                            arr[j].getAnoNascimento() == temp.getAnoNascimento()) {

                        ordenate.addCompares();
                        ordenate.addMove();

                        arr[j + 1] = arr[j];
                        j--;
                        if (j >= 0) {
                            // caso ainda existirem elementos anteriores, atualiza os nomes a serem
                            // comparados
                            cmp = arr[j].getNome().compareToIgnoreCase(temp.getNome());
                            ordenate.addCompares();
                        }
                    }
                }

                arr[j + 1] = temp;
            }
            return arr;
        }

        public void criaHeap(Jogador[] arr, Integer i, Integer f) {
            int pai = i, finalPart = f;

            //
            while ((pai * 2 + 1) <= finalPart) {
                int filho = pai * 2 + 1; // filho representa o filho sendo analisado
                int troca = pai; // troca representa o maior elemento entre os analisados

                // compara o primeiro filho com o pai do nó
                // caso a altura for maior ele devera se tornar o elementro de troca
                if (arr[troca].getAltura() < arr[filho].getAltura()) {
                    ordenate.addCompares();
                    troca = filho;
                }

                // caso a altura for igual, compara os nomes seguindo a mesma lógica
                else if (arr[troca].getAltura() == arr[filho].getAltura() &&
                        arr[troca].getNome().compareTo(arr[filho].getNome()) < 0) {
                    ordenate.addCompares();
                    ordenate.addCompares();
                    troca = filho;
                }

                // realiza as mesmas comparações com o segundo filho e o atual elementro de
                // troca
                if (filho + 1 <= f && arr[troca].getAltura() < arr[filho + 1].getAltura()) {
                    troca = filho + 1;
                }
                ordenate.addCompares();

                if (filho + 1 <= f && arr[troca].getAltura() == arr[filho + 1].getAltura() &&
                        arr[troca].getNome().compareTo(arr[filho + 1].getNome()) < 0) {
                    troca = filho + 1;
                }
                ordenate.addCompares();

                // caso o pai do nó não seja o maior elemento, realiza a troca e ele se torna um
                // filho
                if (troca != pai) {
                    ordenate.addMove();
                    Jogador temp = arr[pai];
                    arr[pai] = arr[troca];
                    arr[troca] = temp;
                    pai = troca;
                } else
                    return;
            }

        }

        public Jogador[] heapSort(Jogador[] arr) {
            // cria heap na primeira metade
            for (int i = arr.length / 2 - 1; i >= 0; i--)
                criaHeap(arr, i, arr.length - 1);

            // ordena o heap
            for (int i = arr.length - 1; i >= 0; i--) {
                Jogador temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                ordenate.addMove();

                criaHeap(arr, 0, i - 1);
            }
            return arr;
        }

        public boolean mergeCompare(Jogador left, Jogador right) {
            ordenate.addCompares();
            if (left.getUniversidade().isEmpty() && !right.getUniversidade().isEmpty()) {
                // Se o jogador esquerdo não tiver nome de universidade e o jogador direito
                // tiver,
                // move o jogador esquerdo para o final do array.
                return false;
            } else if (!left.getUniversidade().isEmpty() && right.getUniversidade().isEmpty()) {
                ordenate.addCompares();
                // Se o jogador direito não tiver nome de universidade e o jogador esquerdo
                // tiver,
                // move o jogador direito para o final do array.
                return true;
            } else if (!left.getUniversidade().isEmpty() && !right.getUniversidade().isEmpty()) {
                ordenate.addCompares();
                ordenate.addCompares();
                // Se ambos os jogadores tiverem nomes de universidades, compare-os.
                if (left.getUniversidade().compareToIgnoreCase(right.getUniversidade()) < 0) {
                    ordenate.addCompares();
                    return true;
                } else if (left.getUniversidade().compareToIgnoreCase(right.getUniversidade()) == 0) {
                    ordenate.addCompares();
                    ordenate.addCompares();
                    ordenate.addCompares();
                    // Se os nomes de universidades forem iguais, compare os nomes dos jogadores.
                    if (left.getNome().compareToIgnoreCase(right.getNome()) < 0) {
                        return true;
                    }
                }
            } else if (left.getUniversidade().isEmpty() && right.getUniversidade().isEmpty()) {
                ordenate.addCompares();
                ordenate.addCompares();
                ordenate.addCompares();
                ordenate.addCompares();

                if (left.getNome().compareToIgnoreCase(right.getNome()) < 0) {
                    return true;
                }
            }
            ordenate.addCompares();
            ordenate.addCompares();
            ordenate.addCompares();
            ordenate.addCompares();

            return false;
        }

        public Jogador[] merge(Jogador[] arr, Jogador[] left, Jogador[] right) {
            Integer i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                // verifica lexografica se o nome da universidade do elemento esquerdo é menor
                // que do direito, caso sim, retorna TRUE
                // caso forem iguais, compara os nomes dos jogadores seguindo a mesma lógica
                ordenate.addCompares();
                if (mergeCompare(left[i], right[j])) {
                    ordenate.addMove();

                    arr[k] = left[i];
                    i++; // prox elemento do vetor esquerdo
                } else {
                    ordenate.addMove();

                    // caso o menor for o elemento do vetor da direita ele ocupa a posição
                    arr[k] = right[j];
                    j++; // prox elemento do vetor direito
                }
                k++; // prox elemento do vetor principal
            }

            // preenche o vetor principal com os elementos que sobraram do vetor esquerdo
            while (i < left.length) {
                ordenate.addCompares();
                ordenate.addMove();

                arr[k] = left[i];
                i++;
                k++;
            }

            while (j < right.length) {
                ordenate.addCompares();
                ordenate.addMove();

                arr[k] = right[j];
                j++;
                k++;
            }

            return arr;
        }

        public Jogador[] mergeSort(Jogador[] arr) {
            if (arr.length > 1) {
                Integer meio = (arr.length - 0) / 2;

                Jogador[] leftArr = Arrays.copyOfRange(arr, 0, meio);
                Jogador[] rightArr = Arrays.copyOfRange(arr, meio, arr.length);

                mergeSort(leftArr);
                mergeSort(rightArr);

                merge(arr, leftArr, rightArr);
            }

            return arr;
        }

        public boolean quickCompareLeft(Jogador left, Jogador pivot) {
            ordenate.addCompares();
            if (left.getEstadoNascimento().compareToIgnoreCase(pivot.getEstadoNascimento()) < 0) {
                return true;
            } else if (left.getEstadoNascimento().compareToIgnoreCase(pivot.getEstadoNascimento()) == 0) {
                ordenate.addCompares();
                ordenate.addCompares();
                if (left.getNome().compareToIgnoreCase(pivot.getNome()) < 0) {
                    return true;
                }
            }
            ordenate.addCompares();

            return false;
        }

        private static int quickSortCompare(Jogador jogador1, Jogador jogador2) {
            boolean vazio1 = jogador1.getEstadoNascimento().isEmpty();
            boolean vazio2 = jogador2.getEstadoNascimento().isEmpty();

            ordenate.addCompares();
            if (vazio1 && vazio2) {
                ordenate.addCompares();
                return jogador1.getNome().compareTo(jogador2.getNome());
            } else if (vazio1) {
                ordenate.addCompares();
                return 1;
            } else if (vazio2) {
                ordenate.addCompares();
                ordenate.addCompares();
                return -1;
            } else {
                ordenate.addCompares();
                ordenate.addCompares();
                ordenate.addCompares();

                int estadoComparison = jogador1.getEstadoNascimento().compareTo(jogador2.getEstadoNascimento());

                if (estadoComparison == 0) {
                    ordenate.addCompares();
                    return jogador1.getNome().compareTo(jogador2.getNome());
                } else {
                    return estadoComparison;
                }
            }
        }

        private int partition(Jogador[] arr, int start, int end) {
            Jogador pivot = arr[end];
            int i = start - 1;
            for (int j = start; j < end; j++) {
                ordenate.addCompares();
                if (quickSortCompare(arr[j], pivot) <= 0) {
                    ordenate.addMove();
                    i++;
                    Jogador aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
            ordenate.addMove();
            Jogador aux = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = aux;
            return i + 1;
        }

        private void quickSortRecursive(Jogador[] arr, int start, int end) {
            ordenate.addCompares();
            if (start < end) {
                int pivotIndex = partition(arr, start, end);
                quickSortRecursive(arr, start, pivotIndex - 1);
                quickSortRecursive(arr, pivotIndex + 1, end);
            }
        }

        public Jogador[] quickSort(Jogador[] arr) {
            quickSortRecursive(arr, 0, arr.length - 1);
            return arr;
        }
    }

    public static class PlayersQueue {
        private int queueSize = 5;
        private int numItens = 0;
        private int firstElement = 0;
        private int lastElement = -1;
        private Jogador[] fifo = new Jogador[queueSize];

        public PlayersQueue(String[] ids, Jogador[] jogadores) {
            // preenche a fila de jogadores
            int integerId = 0;
            for (int i = 0; i < ids.length; i++) {
                for (Jogador jogador : jogadores) {
                    try {
                        integerId = Integer.parseInt(ids[i]);
                    } catch (Exception e) {
                    }
                    if (jogador.getId() == integerId) {
                        this.enqueue(jogador);
                        break;
                    }
                }
            }
        }

        private void enqueue(Jogador jogador) {
            if (this.isFull()) {
                this.lastElement = -1;
            }

            this.lastElement++;
            this.fifo[this.lastElement] = jogador;
            this.numItens++;
        }

        private boolean isFull() {
            if (this.lastElement == this.queueSize - 1) {
                // fila está cheia
                return true;
            }

            return false;
        }

        private boolean isEmpty() {
            if (this.numItens == 0) {
                return true;
            }

            return false;
        }

    }
}