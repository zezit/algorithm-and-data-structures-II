import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class App {
    static Scanner s = new Scanner(System.in);
    static String pathInputFile = "/tmp/jogadores.txt";
    // static String pathInputFile = "/home/jose/coding/algorithm-and-data-structures-II/nba/filas/jogadores.txt";

    static Jogador[] jogadores = lerJogadores();
    static PlayerStack queue = new PlayerStack();
    static String[] ids = new String[0];

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");

        // cria a fila com os jogadores de ids entrados pelo usuário
        queue = new PlayerStack();

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
                    queue.push(jogador);
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

            switch (userInput[0]) {
                case "I":
                    Jogador pushJ = null;
                    try {
                        pushJ = getPlayerById(Integer.parseInt(userInput[1]));
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    if (pushJ != null) {
                        queue.push(pushJ);
                    }
                    break;
                case "R":
                    Jogador dequeJ = queue.pop();

                    if (dequeJ != null) {
                        System.out.println("(R) " + dequeJ.getNome());
                    }
                    break;
                default:
                    break;
            }
        }

        queue.showStack();
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

    public static class PlayerStack {
        private int stackSize = 1;
        private int topElement = -1;
        private Jogador[] lifo;

        public PlayerStack(int maxSize) {
            this.stackSize = maxSize;
            this.lifo = new Jogador[this.stackSize];
        }

        public PlayerStack() {
            this.lifo = new Jogador[this.stackSize];
        }

        public void push(Jogador jogador) {
            if (this.isFull()) {
                this.pop();
            }

            // aumenta o array
            this.lifo = Arrays.copyOf(this.lifo, this.lifo.length + 1);
            this.stackSize++;
            this.topElement++;
            this.lifo[this.topElement] = jogador;
        }

        public Jogador pop() {
            if (this.isEmpty()) {
                return null;
            }

            Jogador jogador = this.lifo[this.topElement];

            this.topElement--;

            return jogador;
        }

        public void showStack() {
            int i = 0, pos = 0;
            while (i <= this.topElement) {
                System.out.print("[" + pos++ + "] ");
                this.lifo[i].imprimir();
                i++;
            }
        }

        private boolean isFull() {
            if (this.topElement == this.stackSize - 1) {
                return true;
            }
            return false;
        }

        private boolean isEmpty() {
            if (this.topElement == -1) {
                return true;
            }
            return false;
        }
    }
}