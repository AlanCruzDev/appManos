package com.app.perfil.Services;

import com.app.perfil.DTO.PostSaveDTO;

public interface IPostRepositoryWrite {
    public String guardarPost(PostSaveDTO postSaveDTO);
}
