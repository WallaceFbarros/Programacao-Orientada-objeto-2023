import java.sql.*;

public class ExemploJDBC {

    public static void main(String[] args) {
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece a conexão
            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
            String usuario = "seu_usuario";
            String senha = "sua_senha";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Cria um Statement
            Statement statement = conexao.createStatement();

            // Executa uma consulta SQL
            ResultSet resultado = statement.executeQuery("SELECT * FROM tabela");

            // Processa os resultados
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id") + ", Nome: " + resultado.getString("nome"));
            }

            // Fecha os recursos
            resultado.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
