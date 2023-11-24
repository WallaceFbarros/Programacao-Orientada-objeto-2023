package poo;

import poo.dao.SerieDAO;
import poo.model.Serie;
import poo.dao.MusicaDAO;
import poo.model.Musica;
import poo.dao.FilmeDAO;
import poo.model.Filme;
import poo.dao.JogoDAO;
import poo.model.Jogo;
import java.util.Scanner;

public class Main {
    
    public static void saudacao(){
        System.out.println("\n------------------------Bem vindo ao programa ------------------------\n\nTema: Stream de Filmes,Jogos,Músicas e séries\nIntegrantes:\n-Felipe Costa\n-Hudson\n-João Pedro Cabral\n-Pedro Angert\n-Wallace Felipe");
    }

    public static void despedida(){
        System.out.println("\nEsse foi o nosso programa\n\n------------------------Obrigado e até a próxima------------------------\n\n");
    }

    public static void printaEscolhas(){
        System.out.println("\n------------------- Você está no menu de escolhas--------------\n1- Sair do programa\n2- Cadastrar\n3- Consultar\n4- Atualizar\n5- Excluir");
    }
    
    public static Integer redireciona(Integer esc, Scanner teclado){
        switch (esc) {
                    case 1://Sair do programa
                        //cria variável para receber escolha  
                        Integer esc1;
                        
                        //menu para confirmar se deseja mesmo sair
                        System.out.println("\nTem certeza que deseja sair?\n1- Sim\n2- Não");
                        esc1 = teclado.nextInt();
                        
                        //trata possíveis erros
                        while(esc1 < 1 || esc1 > 2){
                            System.out.println("\nEscolha inválida, escolha um número entre 1 e 2\n\nTem certeza que deseja sair?\n1- Sim\n2- Não");
                            esc1 = teclado.nextInt();
                        }
                        
                        //caso ele não deseje sair do programa, ele volta para o menu com esc = 0
                        if(esc1 == 2){
                            esc = 0;
                        }
                    break;
                    case 2://cadastrar
                        
                        Integer esc2; //Variável para recolher a escolha
                        
                        //Menu case 2
                        System.out.println("\nO que você deseja cadastrar?\n1- Filme \n2- Série \n3- Música \n4- Jogo");
                        esc2 = teclado.nextInt();
                        
                        //Trata possíveis erros
                        while(esc2 < 1 || esc2 > 4){
                            System.out.println("\nEscolha inválida, escolha um número entre 1 e 4\n\nO que você deseja cadastrar?\n1- Filme\n 2- Série\n 3- Música\n 4- Jogo");
                            esc2 = teclado.nextInt();
                        }

                        switch (esc2) {
                            case 1:
                                cadastrarFilme(teclado);
                            break;
                            case 2:
                                cadastrarSerie(teclado);
                            break;
                            case 3:
                                cadastrarMusica(teclado);
                            break;
                            case 4:
                                cadastrarJogo(teclado);
                            break;
                        }

                    break;
                    case 3://consultar
                        Integer esc3; //Variável para recolher a escolha
                        
                        //Menu case 2
                        System.out.println("\nO que você deseja consultar?\n1- Filme \n2- Série \n3- Música \n4- Jogo");
                        esc3 = teclado.nextInt();
                        
                        //Trata possíveis erros
                        while(esc3 < 1 || esc3 > 4){
                            System.out.println("\nEscolha inválida, escolha um número entre 1 e 4\n\nO que você deseja consultar?\n1- Filme\n 2- Série\n 3- Música\n 4- Jogo");
                            esc3 = teclado.nextInt();
                        }

                        switch (esc3) {
                            case 1:
                                consultarFilme(teclado);
                            break;
                            case 2:
                                consultarSerie(teclado);
                            break;
                            case 3:
                                consultarMusica(teclado);
                            break;
                            case 4:
                                consultarJogo(teclado);
                            break;
                        }

                    break;
                    case 4://atualizar
                        Integer esc4; //Variável para recolher a escolha
                        
                        //Menu case 2
                        System.out.println("\nO que você deseja atualizar?\n1- Filme \n2- Série \n3- Música \n4- Jogo");
                        esc4 = teclado.nextInt();
                        
                        //Trata possíveis erros
                        while(esc4 < 1 || esc4 > 4){
                            System.out.println("\nEscolha inválida, escolha um número entre 1 e 4\n\nO que você deseja atualizar?\n1- Filme\n 2- Série\n 3- Música\n 4- Jogo");
                            esc4 = teclado.nextInt();
                            teclado.nextLine();
                        }

                        switch (esc4) {
                            case 1:
                                atualizarFilme(teclado);
                            break;
                            case 2:
                                atualizarSerie(teclado);
                            break;
                            case 3:
                                atualizarMusica(teclado);
                            break;
                            case 4:
                                atualizarJogo(teclado);
                            break;
                        }

                    break;
                    case 5://excluir
                        Integer esc5; //Variável para recolher a escolha
                        
                        //Menu case 2
                        System.out.println("\nO que você deseja excluir?\n1- Filme \n2- Série \n3- Música \n4- Jogo");
                        esc5 = teclado.nextInt();
                        
                        //Trata possíveis erros
                        while(esc5 < 1 || esc5 > 4){
                            System.out.println("\nEscolha inválida, escolha um número entre 1 e 4\n\nO que você deseja excluir?\n1- Filme\n 2- Série\n 3- Música\n 4- Jogo");
                            esc5 = teclado.nextInt();
                            teclado.nextLine();
                        }

                        switch (esc5) {
                            case 1:
                                excluirFilme(teclado);
                            break;
                            case 2:
                                excluirSerie(teclado);
                            break;
                            case 3:
                                excluirMusica(teclado);
                            break;
                            case 4:
                                excluirJogo(teclado);
                            break;
                        }
                    break;

                }
                return esc;
    }

    public static void cadastrarJogo(Scanner teclado){
        JogoDAO jogoDAO = new JogoDAO();

        //cria variáveis
        Integer Duracao;
        String Titulo;
        String Classificacao;
        String Categoria; 
        String Studio;
        
        //recolhe variáveis
        System.out.println("\nQual a duração do jogo?\n");
        Duracao = teclado.nextInt();
        teclado.nextLine();

        System.out.println("\nQual o título do jogo?\n");
        Titulo = teclado.nextLine();
        

        System.out.println("\nQual a classificação do jogo?\n");
        Classificacao = teclado.nextLine();
        

        System.out.println("\nQual a categoria do jogo?\n");
        Categoria = teclado.nextLine();
        

        System.out.println("\nQual o Studio do jogo?\n");
        Studio = teclado.nextLine();
        
        Jogo jogo = new Jogo(Duracao, Titulo, Classificacao, Categoria, Studio);
        jogoDAO.salvarJogo(jogo);
        jogoDAO.close();
    }

    public static void consultarJogo(Scanner teclado){
        JogoDAO jogoDAO = new JogoDAO();
        Jogo jogoEncontrada = null;
        Long id;

        System.out.println("\nEscreva a Id do jogo que você deseja consultar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o filme pela Id
        jogoEncontrada = jogoDAO.getJogoById(id);
        
        //se não for null
        if(jogoEncontrada != null){
            System.out.println(jogoEncontrada.toString());
            
        }else{
            System.out.println("\nNão existe um jogo com essa Id\n");
        }


    }

    public static void atualizarJogo(Scanner teclado){
        JogoDAO jogoDAO = new JogoDAO();
        Jogo jogoEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id do jogo que você deseja consultar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o jogo pela Id
        jogoEncontrado = jogoDAO.getJogoById(id);

        //se não for null
        if(jogoEncontrado != null){
            
            Integer atributo;
            //opções de atributos
            System.out.println("\nEscolha o atributo do jogo que você deseja modificar\n1- Duracao\n2- Titulo\n3- Classificacao\n4- Categoria\n5- Studio");
            atributo = teclado.nextInt();
            teclado.nextLine();
            

            //Trata possíveis erros
            while(atributo < 1 || atributo > 5){
                System.out.println("\nEscolha inválida, escolha um número entre 1 e 5\n\nEscolha o atributo do jogo que você deseja modificar\n1- Duracao\n2- Titulo\n3- Classificacao\n4- Categoria\n5- Studio");
                atributo = teclado.nextInt();
                teclado.nextLine();
            }

            switch (atributo){
                case 1://Duracao
                    
                    //cria variável
                    Integer Duracao; 

                    //recolhe variável
                    System.out.println("\nQual a nova duração do jogo?\n");
                    Duracao = teclado.nextInt();
                    teclado.nextLine();

                    jogoEncontrado.setDuracao(Duracao);

                break;

                case 2://Titulo
                    //cria variável
                    String Titulo; 

                    //recolhe variável
                    System.out.println("\nQual o novo título do jogo?\n");
                    Titulo = teclado.nextLine();

                    jogoEncontrado.setTitulo(Titulo);

                break;

                case 3://Classificacao
                    //cria variável
                    String Classificacao; 

                    //recolhe variável
                    System.out.println("\nQual a nova classificação do jogo?\n");
                    Classificacao = teclado.nextLine();

                    jogoEncontrado.setClassificacao(Classificacao);
                break;
                
                case 4://Categoria
                    //cria variável
                    String Categoria; 

                    //recolhe variável
                    System.out.println("\nQual a nova categoria do jogo?\n");
                    Categoria = teclado.nextLine();

                    jogoEncontrado.setCategoria(Categoria);
                break;
                case 5://Studio
                    //cria variável
                    String Studio; 

                    //recolhe variável
                    System.out.println("\nQual o novo Studio do jogo?\n");
                    Studio = teclado.nextLine();

                    jogoEncontrado.setStudio(Studio);
                break;
            }
   
            //atualiza o jogo   
            
            jogoDAO.atualizarJogo(jogoEncontrado);
            
        }else{
            System.out.println("\nNão existe um jogo com essa Id\n");
        }

    }

    public static void excluirJogo(Scanner teclado){
        JogoDAO jogoDAO = new JogoDAO();
        Jogo jogoEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id do jogo que você deseja excluir");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o jogo pela Id
        jogoEncontrado = jogoDAO.getJogoById(id);

        //se não for null
        if(jogoEncontrado != null){
            
            //confirmando escolha
            Integer certeza;
            System.out.println("\nTem certeza que deseja excluir o jogo: " + jogoEncontrado.getTitulo() + "\n1- Sim\n2- Não");
            certeza = teclado.nextInt();
            teclado.nextLine();

            //Trata possíveis erros
            while(certeza < 1 || certeza > 2){
                System.out.println("\nEscolha inválida!\nTem certeza que deseja excluir o jogo:" + jogoEncontrado.getTitulo() + "\n1- Sim\n2- Não");
                certeza = teclado.nextInt();
                teclado.nextLine();
            }
            
            if(certeza == 1){
                //Deletando o jogo
                jogoDAO.deletarJogo(jogoEncontrado);
                System.out.println("\nJogo excluído com sucesso!");
            }else{
                System.out.println("\nOperação cancelada voltando para o menu..\n");
            }

        }else{
            System.out.println("\nNão existe uma jogo com essa Id\n");
        }
    }

    public static void cadastrarFilme(Scanner teclado){
        FilmeDAO filmeDAO = new FilmeDAO();

        //cria variáveis
        Integer Duracao; 
        String Titulo; 
        String Classificacao;
        String Categoria; 
        String Diretor; 
        String lancamento;
        
        
        //recolhe variáveis
        System.out.println("\nQual a duração do filme?\n");
        Duracao = teclado.nextInt();
        teclado.nextLine();

        System.out.println("\nQual o título do filme?\n");
        Titulo = teclado.nextLine();
        
        System.out.println("\nQual a classificação do filme?\n");
        Classificacao = teclado.nextLine();
        
        System.out.println("\nQual a categoria do filme?\n");
        Categoria = teclado.nextLine();
        
        System.out.println("\nQual o Diretor do filme?\n");
        Diretor = teclado.nextLine();

        System.out.println("\nQual o lançamento do filme?\n");
        lancamento = teclado.nextLine();
        
        Filme filme = new Filme(Duracao, Titulo, Classificacao, Categoria, Diretor, lancamento);
        filmeDAO.salvarFilme(filme);
        filmeDAO.close();
    }
       
    public static void consultarFilme(Scanner teclado){
        FilmeDAO filmeDAO = new FilmeDAO();
        Filme filmeEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id do filme que você deseja consultar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o filme pela Id
        filmeEncontrado = filmeDAO.getFilmeById(id);
        
        //se não for null
        if(filmeEncontrado != null){
            System.out.println(filmeEncontrado.toString());
            
        }else{
            System.out.println("\nNão existe um filme com essa Id\n");
        }
    }

    public static void atualizarFilme(Scanner teclado){
        FilmeDAO filmeDAO = new FilmeDAO();
        Filme filmeEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id do filme que você deseja atualizar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o filme pela Id
        filmeEncontrado = filmeDAO.getFilmeById(id);

        //se não for null
        if(filmeEncontrado != null){
            
            Integer atributo;
            //opções de atributos
            System.out.println("\nEscolha o atributo do filme que você deseja modificar\n1- Duracao\n2- Titulo\n3- Classificacao\n4- Categoria\n5- Diretor\n6- lancamento");
            atributo = teclado.nextInt();
            teclado.nextLine();
            
            
            //Trata possíveis erros
            while(atributo < 1 || atributo > 6){
                System.out.println("\nEscolha inválida, escolha um número entre 1 e 6\n\nEscolha o atributo do filme que você deseja modificar\n1- Duracao\n2- Titulo\n3- Classificacao\n4- Categoria\n5- Diretor\n6- lancamento");
                atributo = teclado.nextInt();
                teclado.nextLine();
            }
            
            switch (atributo){
                case 1://Duracao
                    
                    //cria variável
                    Integer Duracao; 

                    //recolhe variável
                    System.out.println("\nQual a nova duração do filme?\n");
                    Duracao = teclado.nextInt();
                    teclado.nextLine();

                    filmeEncontrado.setDuracao(Duracao);
                break;

                case 2://Titulo
                    //cria variável
                    String Titulo; 

                    //recolhe variável
                    System.out.println("\nQual o novo título do filme?\n");
                    Titulo = teclado.nextLine();

                    filmeEncontrado.setTitulo(Titulo);
                break;

                case 3://Classificacao
                    //cria variável
                    String Classificacao; 

                    //recolhe variável
                    System.out.println("\nQual a nova classificação do filme?\n");
                    Classificacao = teclado.nextLine();

                    filmeEncontrado.setClassificacao(Classificacao);
                break;
                
                case 4://Categoria
                    //cria variável
                    String Categoria; 

                    //recolhe variável
                    System.out.println("\nQual a nova categoria do filme?\n");
                    Categoria = teclado.nextLine();

                    filmeEncontrado.setCategoria(Categoria);
                break;

                case 5://Diretor
                    //cria variável
                    String Diretor; 

                    //recolhe variável
                    System.out.println("\nQual o novo Diretor do filme?\n");
                    Diretor = teclado.nextLine();

                    filmeEncontrado.setDiretor(Diretor);
                break;

                case 6://lancamento
                    //cria variável
                    String lancamento;

                    //recolhe variável
                    System.out.println("\nQual o lançamento do filme?\n");
                    lancamento = teclado.nextLine();

                    filmeEncontrado.setLancamento(lancamento);
                break;
            }
   
            //atualiza o filme   
            
            filmeDAO.atualizarFilme(filmeEncontrado);
            
        }else{
            System.out.println("\nNão existe um filme com essa Id\n");
        }

    }
    
    public static void excluirFilme(Scanner teclado){
        FilmeDAO filmeDAO = new FilmeDAO();
        Filme filmeEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id do filme que você deseja excluir");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o filme pela Id
        filmeEncontrado = filmeDAO.getFilmeById(id);

        //se não for null
        if(filmeEncontrado != null){
            
            //confirmando escolha
            Integer certeza;
            System.out.println("\nTem certeza que deseja excluir o filme: " + filmeEncontrado.getTitulo() + "\n1- Sim\n2- Não");
            certeza = teclado.nextInt();
            teclado.nextLine();

            //Trata possíveis erros
            while(certeza < 1 || certeza > 2){
                System.out.println("\nEscolha inválida!\nTem certeza que deseja excluir o filme:" + filmeEncontrado.getTitulo() + "\n1- Sim\n2- Não");
                certeza = teclado.nextInt();
                teclado.nextLine();
            }
            
            if(certeza == 1){
                //Deletando o filme
                filmeDAO.deletarFilme(filmeEncontrado);
                System.out.println("\nFilme excluído com sucesso!");
            }else{
                System.out.println("\nOperação cancelada voltando para o menu..\n");
            }

        }else{
            System.out.println("\nNão existe um filme com essa Id\n");
        }
    }
      
    public static void cadastrarSerie(Scanner teclado){
        SerieDAO serieDAO = new SerieDAO();

        //cria variáveis
        String Titulo; 
        String Classificacao; 
        String Categoria; 
        Integer Temporada; 
        Integer Episodio;
        
        
        //recolhe variáveis
        teclado.nextLine();
        System.out.println("\nQual o título da série?\n");
        Titulo = teclado.nextLine();
        

        System.out.println("\nQual a classificação da série?\n");
        Classificacao = teclado.nextLine();
        

        System.out.println("\nQual a categoria da série?\n");
        Categoria = teclado.nextLine();
        

        System.out.println("\nQuantas temporadas tem a série?\n");
        Temporada = teclado.nextInt();
        teclado.nextLine();

        System.out.println("\nQuantos episodios tem a série?\n");
        Episodio = teclado.nextInt();
        teclado.nextLine();
            
        
        
        Serie serie = new Serie(Titulo, Classificacao, Categoria, Temporada, Episodio);
        serieDAO.salvarSerie(serie);
        serieDAO.close();
    }  
    
    public static void consultarSerie(Scanner teclado){
        SerieDAO serieDAO = new SerieDAO();
        Serie serieEncontrada = null;
        Long id;

        System.out.println("\nEscreva a Id da serie que você deseja consultar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o filme pela Id
        serieEncontrada = serieDAO.getSerieById(id);
        
        //se não for null
        if(serieEncontrada != null){
            System.out.println(serieEncontrada.toString());
            
        }else{
            System.out.println("\nNão existe uma série com essa Id\n");
        }


    }    
        
    public static void atualizarSerie(Scanner teclado){
        SerieDAO serieDAO = new SerieDAO();
        Serie serieEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id da série que você deseja atualizar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o serie pela Id
        serieEncontrado = serieDAO.getSerieById(id);

        //se não for null
        if(serieEncontrado != null){
            
            Integer atributo;
            //opções de atributos
            System.out.println("\nEscolha o atributo da série que você deseja modificar\n1- Titulo\n2- Classificacao\n3- Categoria\n4- Temporada\n5- Episodio");
            atributo = teclado.nextInt();
            teclado.nextLine();
            
            
            //Trata possíveis erros
            while(atributo < 1 || atributo > 5){
                System.out.println("\nEscolha inválida, escolha um número entre 1 e 5\n\nEscolha o atributo da série que você deseja modificar\n1- Titulo\n2- Classificacao\n3- Categoria\n4- Temporada\n5- Episodio");
                atributo = teclado.nextInt();
                teclado.nextLine();
            }
            
            switch (atributo){
                case 1://Titulo
                    //cria variável
                    String Titulo; 

                    //recolhe variável
                    System.out.println("\nQual o novo título da série?\n");
                    Titulo = teclado.nextLine();

                    serieEncontrado.setTitulo(Titulo);

                break;

                case 2://Classificacao
                    //cria variável
                    String Classificacao; 

                    //recolhe variável
                    System.out.println("\nQual a nova classificação da série?\n");
                    Classificacao = teclado.nextLine();

                    serieEncontrado.setClassificacao(Classificacao);
                break;
                
                case 3://Categoria
                    //cria variável
                    String Categoria; 

                    //recolhe variável
                    System.out.println("\nQual a nova categoria da série?\n");
                    Categoria = teclado.nextLine();

                    serieEncontrado.setCategoria(Categoria);
                break;

                case 4://Temporada
                    //cria variável
                    Integer Temporada; 

                    //recolhe variável
                    System.out.println("\nQual a nova quantidade de Temporadas da série?\n");
                    Temporada = teclado.nextInt();
                    teclado.nextLine();

                    serieEncontrado.setTemporada(Temporada);
                break;

                case 5://Episodio
                    //cria variável
                    Integer Episodio;

                    //recolhe variável
                    System.out.println("\nQual a nova quantidade de episódios da série?\n");
                    Episodio = teclado.nextInt();

                    serieEncontrado.setEpisodio(Episodio);
                break;
            }
   
            //atualiza o serie   
            
            serieDAO.atualizarSerie(serieEncontrado);
            
        }else{
            System.out.println("\nNão existe um serie com essa Id\n");
        }

    }
        
    public static void excluirSerie(Scanner teclado){
        SerieDAO serieDAO = new SerieDAO();
        Serie serieEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id da série que você deseja excluir");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o serie pela Id
        serieEncontrado = serieDAO.getSerieById(id);

        //se não for null
        if(serieEncontrado != null){
            
            //confirmando escolha
            Integer certeza;
            System.out.println("\nTem certeza que deseja excluir a série: " + serieEncontrado.getTitulo() + "\n1- Sim\n2- Não");
            certeza = teclado.nextInt();
            teclado.nextLine();

            //Trata possíveis erros
            while(certeza < 1 || certeza > 2){
                System.out.println("\nEscolha inválida!\nTem certeza que deseja excluir a série:" + serieEncontrado.getTitulo() + "\n1- Sim\n2- Não");
                certeza = teclado.nextInt();
                teclado.nextLine();
            }
            
            if(certeza == 1){
                //Deletando a serie
                serieDAO.deletarSerie(serieEncontrado);
                System.out.println("\nSerie excluída com sucesso!");
            }else{
                System.out.println("\nOperação cancelada voltando para o menu..\n");
            }

        }else{
            System.out.println("\nNão existe uma série com essa Id\n");
        }
    }
       
    public static void cadastrarMusica(Scanner teclado){
        MusicaDAO musicaDAO = new MusicaDAO();

        //cria variáveis
        Integer Duracao; 
        String Titulo; 
        String Artista;
        
        
        //recolhe variáveis
        System.out.println("\nQual a duração da música?\n");
        Duracao = teclado.nextInt();
        teclado.nextLine();

        System.out.println("\nQual o título da musica?\n");
        Titulo = teclado.nextLine();

        System.out.println("\nQual o Artista da música?\n");
        Artista = teclado.nextLine();
        
        Musica musica = new Musica(Duracao, Titulo, Artista);
        musicaDAO.salvarMusica(musica);
        musicaDAO.close();
    }
    
    public static void consultarMusica(Scanner teclado){
        MusicaDAO musicaDAO = new MusicaDAO();
        Musica musicaEncontrada = null;
        Long id;

        System.out.println("\nEscreva a Id da música que você deseja consultar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o filme pela Id
        musicaEncontrada = musicaDAO.getMusicaById(id);
        
        //se não for null
        if(musicaEncontrada != null){
            System.out.println(musicaEncontrada.toString());
            
        }else{
            System.out.println("\nNão existe uma música com essa Id\n");
        }


    }

    public static void atualizarMusica(Scanner teclado){
        MusicaDAO musicaDAO = new MusicaDAO();
        Musica musicaEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id da música que você deseja consultar");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando o musica pela Id
        musicaEncontrado = musicaDAO.getMusicaById(id);

        //se não for null
        if(musicaEncontrado != null){
            
            Integer atributo;
            //opções de atributos
            System.out.println("\nEscolha o atributo da música que você deseja modificar\n1- Duracao\n2- Titulo\n3- Artista");
            atributo = teclado.nextInt();
            teclado.nextLine();
            

            //Trata possíveis erros
            while(atributo < 1 || atributo > 3){
                System.out.println("\nEscolha inválida, escolha um número entre 1 e 3\n\nEscolha o atributo da música que você deseja modificar\n1- Duracao\n2- Titulo\n3- Artista");
                atributo = teclado.nextInt();
                teclado.nextLine();
            }
            

            switch (atributo){
                case 1://Duracao
                    
                    //cria variável
                    Integer Duracao; 

                    //recolhe variável
                    System.out.println("\nQual a nova duração da música?\n");
                    Duracao = teclado.nextInt();
                    teclado.nextLine();

                    musicaEncontrado.setDuracao(Duracao);

                break;

                case 2://Titulo
                    //cria variável
                    String Titulo; 

                    //recolhe variável
                    System.out.println("\nQual o novo título da música?\n");
                    Titulo = teclado.nextLine();

                    musicaEncontrado.setTitulo(Titulo);

                break;
                
                case 3://Artista
                    //cria variável
                    String Artista; 

                    //recolhe variável
                    System.out.println("\nQual o novo Artista da música?\n");
                    Artista = teclado.nextLine();

                    musicaEncontrado.setArtista(Artista);
                break;
            }
   
            //atualiza a musica   
            
            musicaDAO.atualizarMusica(musicaEncontrado);
            
        }else{
            System.out.println("\nNão existe uma musica com essa Id\n");
        }

    }

    public static void excluirMusica(Scanner teclado){
        MusicaDAO musicaDAO = new MusicaDAO();
        Musica musicaEncontrado = null;
        Long id;

        System.out.println("\nEscreva a Id da música que você deseja excluir");
        id = teclado.nextLong();
        teclado.nextLine();

        //pegando a musica pela Id
        musicaEncontrado = musicaDAO.getMusicaById(id);

        //se não for null
        if(musicaEncontrado != null){
            
            //confirmando escolha
            Integer certeza;
            System.out.println("\nTem certeza que deseja excluir a música: " + musicaEncontrado.getTitulo() + "\n1- Sim\n2- Não");
            certeza = teclado.nextInt();
            teclado.nextLine();

            //Trata possíveis erros
            while(certeza < 1 || certeza > 2){
                System.out.println("\nEscolha inválida!\nTem certeza que deseja excluir a música:" + musicaEncontrado.getTitulo() + "\n1- Sim\n2- Não");
                certeza = teclado.nextInt();
                teclado.nextLine();
            }
            
            if(certeza == 1){
                //Deletando a música
                musicaDAO.deletarMusica(musicaEncontrado);
                System.out.println("\nMusica excluída com sucesso!");
            }else{
                System.out.println("\nOperação cancelada voltando para o menu..\n");
            }

        }else{
            System.out.println("\nNão existe uma música com essa Id\n");
        }
    }

    public static void main(String[] args) {
        //Pequena saudação para ficar mais bonito
        saudacao();
        
        Integer esc = 0;//variável que será usada para definir a escolhado usuário
        
        try (Scanner teclado = new Scanner(System.in)) {//variável para colher a escolha do usuário
            
            //1º while serve para o usuário ficar voltando nesse menu até ele escolher "sair"
            while(esc != 1){
                //Escolhas possívei no programa
                printaEscolhas();

                //recebe a escolha do usuário pelo teclado
                esc = teclado.nextInt();
                teclado.nextLine();

                //Trata possíveis erros
                while(esc < 1 || esc > 5){
                    System.out.println("\nEscolha inválida, escolha um número entre 1 e 5\n");
                    printaEscolhas();
                    esc = teclado.nextInt();
                }
                
                //redireciona para opção desejada 
                esc = redireciona(esc, teclado);
                
            }
        }

        despedida();

    }
}