package com.CyberSoft.uniclubWeb.service.imp;

import com.CyberSoft.uniclubWeb.entity.RolesEntity;

import javax.management.relation.Role;
import java.util.List;

public interface RolesServiceImp {
    List<RolesEntity> getAllRole();

//    boolean isRoleExit(int id);
    boolean deleteRoleById(int role_id);
}
