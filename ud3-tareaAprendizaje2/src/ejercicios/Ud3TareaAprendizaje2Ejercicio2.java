package ejercicios;

import java.sql.*;

public class Ud3TareaAprendizaje2Ejercicio2 {

    public static void main(String[] args) {

        int i = 0;

        if (args.length < 2) {
            System.out.println("No has introducido la información en los argumentos del main");
            return; // Si no hay argumentos suficientes, salimos del método.
        }

        Integer numDep = Integer.valueOf(args[1]);
        String newName = args[0];

        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "demodb";
        String password = "demodb";

        // Utilizamos try-with-resources para asegurarnos que los recursos sean cerrados automáticamente
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sqlUpdate = "UPDATE DEPT SET DNAME = '" + newName + "' WHERE DEPTNO = " + numDep + ";";
            i = stmt.executeUpdate(sqlUpdate);

            System.out.println("El nuevo nombre del departamento " + numDep + " es: " + newName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Filas afectadas: " + i);
    }
}