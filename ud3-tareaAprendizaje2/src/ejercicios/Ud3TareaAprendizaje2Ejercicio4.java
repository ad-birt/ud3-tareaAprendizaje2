package ejercicios;

import java.sql.*;

public class Ud3TareaAprendizaje2Ejercicio4 {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("No has introducido la información en los argumentos del main");
            return;
        }

        Integer numDep = Integer.valueOf(args[1]);
        String newName = args[0];
        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "demodb";
        String password = "demodb";

        int i = 0;
        String updateQuery = "UPDATE DEPT SET DNAME = ? WHERE DEPTNO = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false); // Desactivo el commit para cada sentencia

            try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
                ps.setString(1, newName);
                ps.setInt(2, numDep);
                i = ps.executeUpdate();

                conn.commit(); // Al finalizar sentencias hago commit
            } catch (SQLException e) {
                conn.rollback(); // Si algo falla hago rollback para dejarlo como antes
                e.printStackTrace();
            } finally {
                conn.setAutoCommit(true); // Y vuelvo a activar autocommit para resto de aplicación
            }

            System.out.println("El nuevo nombre del departamento " + numDep + " es: " + newName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Filas afectadas: " + i);
    }
}