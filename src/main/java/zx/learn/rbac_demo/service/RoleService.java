package zx.learn.rbac_demo.service;

import org.springframework.stereotype.Service;
import zx.learn.rbac_demo.entity.Resource;
import zx.learn.rbac_demo.entity.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/6
 * Time: 8:16
 * Description: 对角色拥有的一些操作。
 */

public interface RoleService {

    /**
     * 禁用某个角色
     *
     * @param roleId 角色ID
     * @return 是否禁用成功。
     */
    public Boolean banRole(Integer roleId);

    /**
     * 通过角色的 ID 获取角色信息
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    public Role getRoleByRoleId(Integer roleId);

    /**
     * 新增角色
     *
     * @param role 需要新增的角色的信息 ID自增
     * @return 新增成功的角色信息
     */
    public Role addRole(Role role);

    /**
     * 删除角色
     *
     * @param role 需要新增的角色的信息
     * @return 新增成功的角色信息
     */
    public Boolean deleteRole(Role role);

    /**
     * 更新角色信息
     *
     * @param roleId 将要更新的角色的ID
     * @param roleName 更新后的角色名
     * @return 更新后的角色信息
     */
    public Role updateRole(Integer roleId, String roleName);

    public List<Role> listAllRole();

    public List<Resource> listResourceByRoleId(Integer roleId);


}