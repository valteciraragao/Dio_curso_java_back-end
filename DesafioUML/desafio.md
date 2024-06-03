classDiagram
    iPhone <|-- Ipod
    iPhone <|-- Photos
    iPhone <|-- Calendar
    iPhone <|-- Phone
    iPhone <|-- Texting
    iPhone <|-- SafariBrowser
    iPhone <|-- GoogleMaps
    iPhone <|-- RichEmail
    iPhone : +ligar()
    iPhone: +desligar()
    iPhone: +desbloquear()
    iPhone: +home()
    class Ipod{
        <<interface>>
        +tocar(String musica)
        +mostrarArtista(String artista)
        +mostrarAlbum(String album)
        +selecionarMusica(String musica)
        +selecionarArtista(String artista)
    }
    class Photos{
        <<interface>>
        +selecionarFoto(String foto)
        +mostrarFoto(String foto)
        +gerarPapelParede(String foto)
    }
    class Calendar{
        <<interface>>
        +verCalendario()
        +adicionarCompromisso(String data)
    }
    class Phone{
        <<interface>>
        +ligar(int numero)
        +desligar()
        +criarContato()
        +listarContatos()
        +favoritos()
    }
    class Texting{
        <<interface>>
        +enviarSMS()
        +selecionarConversa()
    }
    class SafariBrowser{
        <<interface>>
        +navegar(String enderecoWeb)
        +criarNovaAba(String enderecoWeb)
        +navegarPaginas()
    }
    class GoogleMaps{
        <<interface>>
        +mostrarLocal(String endereco)
        +mostarLocalSatelite(String endereco)
    }
    class RichEmail{
        <<interface>>
        +verEmail()
        +escreverEmail()
        +enviarEmail()
        +adicionarAnexo()
    }
    