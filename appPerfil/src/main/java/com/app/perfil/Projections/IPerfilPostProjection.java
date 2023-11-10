package com.app.perfil.Projections;

import java.sql.Clob;

public interface IPerfilPostProjection {
    Long getID();
    String getDESCRIPCION();
    Clob getFOTO_PERFIL();
    String getPOST_JSON();
}
