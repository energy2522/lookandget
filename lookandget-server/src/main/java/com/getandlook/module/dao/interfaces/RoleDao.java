package com.getandlook.module.dao.interfaces;

import com.getandlook.module.domain.Role;

import java.util.List;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface RoleDao {

    List<Role> getAllRole();

    void create(Role role);
}
