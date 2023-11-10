package com.app.perfil.Services;

import com.app.perfil.DTO.PerfilSaveDTO;
import com.app.perfil.Services.FuncionesOracle.IOracleFunciones;
import com.app.perfil.anotaciones.AnotacionPerfil;
import com.app.perfil.procesador.JsonSerializador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilRepositoryWriteImpl implements  IPerfilRepositoryWrite{

    @Autowired
    private IOracleFunciones iOracleFunciones;

    @Override
    public String guardarPerfil(PerfilSaveDTO perfilSaveDTO,Integer idCliente) {
        String response ="";
        AnotacionPerfil anotacionPerfil = new AnotacionPerfil();
        try{
            anotacionPerfil.setFotoPerfil(perfilSaveDTO.getFotoPerfil());
            anotacionPerfil.setDescripcion(perfilSaveDTO.getDescripcion());
            anotacionPerfil.setIdCliente(idCliente.toString());
            String _data = JsonSerializador.ConvertJson(anotacionPerfil);
            System.out.println("JSON: "+_data);
            response=iOracleFunciones.guardarPerfil(_data,idCliente);
        }catch (Exception e){
            System.out.println("ERROR METHOD guardarPerfil: "+e);
        }
        return response;
    }
}
