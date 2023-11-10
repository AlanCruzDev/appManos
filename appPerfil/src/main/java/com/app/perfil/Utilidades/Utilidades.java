package com.app.perfil.Utilidades;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

public class Utilidades {

    public static String clobToString(Clob clob) {
        StringBuilder contenido = new StringBuilder();
        try(Reader reader = clob.getCharacterStream(); BufferedReader bufferedReader = new BufferedReader(reader)){
            String linea;
            while((linea=bufferedReader.readLine()) != null) {
                contenido.append(linea);
            }
        }catch(SQLException | IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }

}
