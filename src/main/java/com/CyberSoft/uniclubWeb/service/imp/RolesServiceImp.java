package com.CyberSoft.uniclubWeb.service.imp;

import com.CyberSoft.uniclubWeb.entity.RoleEntity;

import java.util.List;

public interface RolesServiceImp {
    List<RoleEntity> getAllRole();

//    boolean isRoleExit(int id);
    boolean deleteRoleById(int role_id);
}
