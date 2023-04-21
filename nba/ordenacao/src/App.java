import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class App {
    static Ordenate ordenate = new Ordenate();
    static Scanner s = new Scanner(System.in);
    static String pathInputFile = "/tmp/jogadores.txt";
    // static String pathInputFile = "S:\\Users\\José Victor\\dev\\algorithm-and-data-structures-II\\nba\\ordenacao\\src\\jogadores.txt";
    // static String pathInputFile =
    // "/home/jose/coding/algorithm-and-data-structures-II/nba/ordenacao/src/jogadores.txt";

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");

        // lê os dados dos jogadores
        Jogador[] jogadores = lerJogadores();

        // Array com ids
        String[] ids = new String[0];

        String id = "";

        try {
            id = s.nextLine();
        } catch (Exception e) {
            // TODO: handle exception
        }

        do {
            ids = Arrays.copyOf(ids, ids.length + 1);
            ids[ids.length - 1] = id;

            try {
                id = s.nextLine();
            } catch (Exception e) {
                // TODO: handle exception
            }
        } while (!id.equals("FIM") && id.length() > 0);

        Jogador[] orderedJogadores;
        orderedJogadores = new Jogador[ids.length];

        int integerId = 0;
        for (int i = 0; i < ids.length; i++) {
            for (Jogador jogador : jogadores) {
                try {
                    integerId = Integer.parseInt(ids[i]);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                if (jogador.getId() == integerId) {
                    orderedJogadores[i] = jogador;
                    break;
                }
            }
        }

        s.close();

        // Método BubbleSort
        // orderedJogadores = ordenate.bubble_sort(orderedJogadores);
        // for (Jogador jogador : orderedJogadores) {
        // jogador.imprimir();
        // }

        // Método SelectionSort
        // orderedJogadores = ordenate.selection_sort(orderedJogadores);
        // for (Jogador jogador : orderedJogadores) {
        // jogador.imprimir();
        // }

        // Método InsertionSort
        orderedJogadores = ordenate.insertion_sort(orderedJogadores);
        for (Jogador jogador : orderedJogadores) {
            jogador.imprimir();
        }
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
            Jogador jogador = new Jogador(linha);
            try {
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

    public static class Ordenate {
        public Jogador[] bubble_sort(Jogador[] arr) {
            Jogador[] jogadoresOrdenados = arr;

            Jogador aux = null;
            for (int i = 0; i < jogadoresOrdenados.length; i++) {
                for (int j = 1; j < jogadoresOrdenados.length - 1; j++) {
                    int compareVal = 100;

                    if (jogadoresOrdenados[j - 1].getCidadeNascimento().length() > 0) {
                        compareVal = jogadoresOrdenados[j - 1].getCidadeNascimento()
                                .compareTo(jogadoresOrdenados[j].getCidadeNascimento());
                    }

                    if (compareVal == 0) {
                        // strings iguais
                        compareVal = jogadoresOrdenados[j - 1].getNome()
                                .compareTo(jogadoresOrdenados[j].getNome());
                    }

                    if (compareVal < 0) {
                        // a < b (lexo)

                    } else {
                        // a > b (lexo)
                        aux = jogadoresOrdenados[j - 1];
                        jogadoresOrdenados[j - 1] = jogadoresOrdenados[j];
                        jogadoresOrdenados[j] = aux;
                    }
                }
            }

            return jogadoresOrdenados;
        }

        public Jogador[] selection_sort(Jogador[] arr) {
            Jogador[] jogadoresOrdenados = arr;
            Jogador auxJogador = new Jogador();

            for (int i = 0; i < jogadoresOrdenados.length; i++) {
                Jogador menor = jogadoresOrdenados[i];
                for (int j = i + 1; j < jogadoresOrdenados.length; j++) {
                    int compareVal = jogadoresOrdenados[j].getNome().compareTo(menor.getNome());

                    if (compareVal < 0) {
                        // a < b (lexo)
                        menor = jogadoresOrdenados[j];

                    }
                    if (jogadoresOrdenados[i].getNome() != menor.getNome()) {
                        auxJogador = jogadoresOrdenados[i];
                        jogadoresOrdenados[i] = menor;
                        jogadoresOrdenados[j] = auxJogador;
                    }
                }
            }

            return jogadoresOrdenados;
        }

        public Jogador[] insertion_sort(Jogador[] arr) {
            Jogador[] vetor = arr;

            for (int i = 1; i < vetor.length; i++) {
                Jogador temp = vetor[i];
                int j = i - 1;

                while (j >= 0 && vetor[j].getAnoNascimento() > temp.getAnoNascimento()) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }

                if (j >= 0 && vetor[j].getAnoNascimento() == temp.getAnoNascimento()) {
                    int cmp = vetor[j].getNome().compareToIgnoreCase(temp.getNome());
                    while (j >= 0 && vetor[j].getAnoNascimento() == temp.getAnoNascimento() && cmp > 0) {
                        vetor[j + 1] = vetor[j];
                        j--;
                        if (j >= 0) {
                            cmp = vetor[j].getNome().compareToIgnoreCase(temp.getNome());
                        }
                    }
                }

                vetor[j + 1] = temp;
            }
            return vetor;
        }
    }
}
