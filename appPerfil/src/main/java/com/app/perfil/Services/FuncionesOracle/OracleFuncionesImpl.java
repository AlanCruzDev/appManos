package com.app.perfil.Services.FuncionesOracle;

import com.app.perfil.Utilidades.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import java.sql.Types;
import java.util.Map;
import java.sql.Clob;

@Service
public class OracleFuncionesImpl implements IOracleFunciones {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String guardarPerfilCliente(String json_texto) {
        String contenidoClob ="";

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("guardarPost")
                .declareParameters(
                        new SqlParameter("post_json", Types.CLOB));
        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("post_json",json_texto, Types.CLOB);

        Map<String, Object> result = jdbcCall.execute(inParams);
        Clob C = (Clob) result.get("return");

        try {
            contenidoClob = Utilidades.clobToString(C);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR FUNCION guardarPerfilCliente: "+e);
        }
        return contenidoClob;

    }

    @Override
    public String guardarPerfil(String json_texto, Integer idCliente) {
        String contenidoClob = "";
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("save_perfil")
                .declareParameters(
                        new SqlParameter("json_perfil",Types.CLOB),
                        new SqlParameter("idCliente", Types.INTEGER));
        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("json_perfil",json_texto,Types.CLOB)
                .addValue("idCliente",idCliente,Types.INTEGER);
        Map<String,Object> result = simpleJdbcCall.execute(inParams);
        Clob C = (Clob) result.get("return");
        try {
            contenidoClob = Utilidades.clobToString(C);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR FUNCION guardarPerfilCliente: "+e);
        }
        return contenidoClob;
    }
}
