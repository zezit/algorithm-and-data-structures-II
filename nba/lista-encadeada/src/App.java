import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class App {
    static Scanner s = new Scanner(System.in);
    static String pathInputFile = "/tmp/jogadores.txt";
    // static String pathInputFile = "/home/jose/coding/algorithm-and-data-structures-II/nba/lista/jogadores.txt";

    static Jogador[] jogadores = lerJogadores();
    static PlayerLinkedList mainList = new PlayerLinkedList();
    static String[] ids = new String[0];

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");

        // cria a fila com os jogadores de ids entrados pelo usuário
        mainList = new PlayerLinkedList();

        // lê as ids dos jogadores para serem ordenados
        readUserEntry();

        int integerId = 0;
        for (int i = 0; i < ids.length; i++) {
            for (Jogador jogador : jogadores) {
                try {
                    integerId = Integer.parseInt(ids[i]);
                } catch (Exception e) {
                }
                if (jogador.getId() == integerId) {
                    mainList.insert(jogador, i);
                }
            }
        }

        processDefaultEntry();
    }

    public static void processDefaultEntry() {
        int numReads = 0;
        try {
            numReads = Integer.parseInt(s.nextLine());
        } catch (Exception e) {
        }

        String[] inputs = new String[numReads];

        for (int i = 0; i < numReads; i++) {
            try {
                inputs[i] = s.nextLine();
            } catch (Exception e) {
            }
        }

        for (String string : inputs) {
            String[] userInput = string.split(" ");

            /*
             * II: inserir no início;
             * • I* inserir em uma determinada posição;
             * • IF: inserir no final;
             * • RI: remover do início;
             * • R*: remover de uma determinada posição;
             * • RF: remover do final.
             * 
             */
            switch (userInput[0]) {
                // start insert
                case "II":
                    Jogador pushJ = null;
                    try {
                        pushJ = getPlayerById(Integer.parseInt(userInput[1]));
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    if (pushJ != null) {
                        mainList.insert(pushJ, 0);
                    }
                    break;
                case "I*":
                    Jogador pushJ2 = null;
                    try {
                        pushJ2 = getPlayerById(Integer.parseInt(userInput[2]));
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    if (pushJ2 != null) {
                        mainList.insert(pushJ2, Integer.parseInt(userInput[1]));
                    }
                    break;
                case "IF":
                    Jogador pushJ3 = null;
                    try {
                        pushJ3 = getPlayerById(Integer.parseInt(userInput[1]));
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    if (pushJ3 != null) {
                        mainList.insert(pushJ3, mainList.getSize() - 1);
                    }
                    break;
                case "RI":
                    mainList.remove(0);
                    break;
                case "R*":
                    mainList.remove(Integer.parseInt(userInput[1]));
                    break;
                case "RF":
                    mainList.remove(mainList.getSize() - 1);
                    break;
                default:
                    break;
            }
        }

        mainList.showStack();
        s.close();
    }

    public static void readUserEntry() {
        String id = new String();

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
    }

    public static Jogador getPlayerById(int id) {
        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                return jogador;
            }
        }
        return null;
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
            System.out.print("## " + this.id);

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

            System.out.print(" ##\n");
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

    public static class Cell {

        private Jogador item;
        private Cell proximo;

        public Cell(Jogador novo) {
            item = novo;
            proximo = null;
        }

        public Cell() {
            item = null;
            proximo = null;
        }

        public Jogador getItem() {
            return item;
        }

        public void setItem(Jogador item) {
            this.item = item;
        }

        public Cell getProximo() {
            return proximo;
        }

        public void setProximo(Cell proximo) {
            this.proximo = proximo;
        }
    }

    public static class PlayerLinkedList {
        private int listSize;
        private Cell lastElement;
        private Cell firstElement;

        public PlayerLinkedList() {
            Cell sentinela = new Cell();
            this.firstElement = sentinela;
            this.lastElement = sentinela;
            this.listSize = 0;
        }

        public int getSize() {
            return this.listSize;
        }

        // public void insertOnEnd(Jogador jogador) {
        // Cell newCell = new Cell(jogador);
        // this.lastElement.setProximo(newCell);
        // this.lastElement = newCell;
        // this.listSize++;
        // }

        public void insert(Jogador jogador, int position) {
            if (position < 0 || position > this.listSize) {
                return;
            }

            Cell newCell, nextCell, lastCell;
            lastCell = this.firstElement;

            for (int i = 0; i < position; i++) {
                lastCell = lastCell.getProximo();
            }

            newCell = new Cell(jogador);
            nextCell = lastCell.getProximo();
            lastCell.setProximo(newCell);
            newCell.setProximo(nextCell);

            if (position == this.listSize)
                this.lastElement = newCell;

            this.listSize++;
        }

        // public void insertAtStart(Jogador jogador) {
        // // aumenta o array
        // this.list = Arrays.copyOf(this.list, this.list.length + 1);
        // this.listSize++;

        // // move os elementos para a direita
        // for (int i = this.listSize - 1; i > 0; i--) {
        // this.list[i] = this.list[i - 1];
        // }

        // // insere o elemento na posição
        // this.list[0] = jogador;
        // }

        // public Jogador removeStart() {
        // if (this.isEmpty()) {
        // return null;
        // }

        // Jogador removed = this.list[0];
        // System.out.println("(R) " + removed.getNome());

        // // move os elementos para a esquerda
        // for (int i = 0; i < this.listSize - 1; i++) {
        // this.list[i] = this.list[i + 1];
        // }

        // // diminui o array
        // this.list = Arrays.copyOf(this.list, this.list.length - 1);
        // this.listSize--;

        // return removed;
        // }

        // public Jogador removeEnd() {
        // if (this.isEmpty()) {
        // return null;
        // }

        // Jogador removed = this.list[this.listSize - 1];
        // System.out.println("(R) " + removed.getNome());

        // // diminui o array
        // this.list = Arrays.copyOf(this.list, this.list.length - 1);
        // this.listSize--;

        // this.lastElement = this.list[this.listSize - 1];

        // return removed;
        // }

        public Jogador remove(int position) {
            if (position < 0 || position > this.listSize) {
                return null;
            }

            Cell removedCell, nextCell, lastCell;
            lastCell = this.firstElement;

            for (int i = 0; i < position; i++) {
                lastCell = lastCell.getProximo();
            }

            removedCell = lastCell.getProximo();

            nextCell = removedCell.getProximo();
            lastCell.setProximo(nextCell);
            removedCell.setProximo(null);

            if (removedCell == this.lastElement)
                this.lastElement = lastCell;

            this.listSize--;

            System.out.println("(R) " + removedCell.getItem().getNome());
            return removedCell.getItem();
        }

        public void showStack() {
            Cell currentCell = this.firstElement.getProximo();
            for (int i = 0; i < this.listSize; i++) {
                System.out.print("[" + i + "] ");
                currentCell.getItem().imprimir();
                currentCell = currentCell.getProximo();
            }
        }

        // private boolean isEmpty() {
        // if (this.firstElement == this.lastElement)
        // return true;
        // return false;
        // }
    }
}