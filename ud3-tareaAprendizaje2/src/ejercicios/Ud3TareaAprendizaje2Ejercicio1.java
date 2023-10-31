package ejercicios;

import java.sql.*;

public class Ud3TareaAprendizaje2Ejercicio1 {

    public static void main(String[] args) {

        // Propiedades
        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "demodb";
        String password = "demodb";

        // Trabajo con base de datos
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select deptno, dname from DEPT")
        ){
            while(rs.next()){
                int numDept = rs.getInt("deptno");
                String nombre = rs.getString("dname");
                System.out.println("Departamento: " + numDept + ". Nombre: " + nombre);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}