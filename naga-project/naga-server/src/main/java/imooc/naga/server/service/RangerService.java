package imooc.naga.server.service;

import imooc.naga.entity.privilege.ResourcePrivilege;

import java.util.List;

public interface RangerService {
    void addRangerUser(String name, String firstName, String lastName, String password, List<String> roles);

    void removeRangerUser(String name);

    void addPolicy(ResourcePrivilege resourcePrivilege);

    void removePolicy(String name);
}
