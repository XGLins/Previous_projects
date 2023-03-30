package com.dingli.dao;

import com.dingli.entity.Department;
import com.dingli.util.JdbcTools;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DepartmentDAO {

    //注入JdbcTools全局变量
    private JdbcTools jt = new JdbcTools();

    /**
     * Map转Department的orm映射方法
     *
     * @param map 传入的map
     * @return Department对象
     */
    public Department ormDpt(Map<String, Object> map) {
        Department department = new Department();

        if (map.get("did") != null) {
            department.setDid((int) map.get("did"));
        }
        if (map.get("dname") != null) {
            department.setDname((String) map.get("dname"));
        }
        if (map.get("info") != null) {
            department.setInfo((String) map.get("info"));
        }
        return department;
    }


    //部门相关操作，将方法写入DepartmentDAO中，该方法查询部门表所有信息，返回List结果集
    public List<Department> selectAll(){
        String sql = "select * from department";
        List<Map<String,Object>> list = jt.select(sql);
        if (list.size() == 0){
            return null;
        }
        List<Department> result = new LinkedList<>();
        list.forEach(one ->{
            result.add(ormDpt(one));
        });
        return result;
    }

    //返回JDBC操作后的结果值（插入）
    public int insert(Department dpt){
        String sql = "insert into department(dname,info) value(?,?)";
        return jt.insert(sql, dpt.getDname(), dpt.getInfo());

    }

    //通过id查询出指定部门信息（根据ID进行查询）
    public Department selectById(int did){
        String sql = "select * from department where did=?";
        List<Map<String, Object>> list = jt.select(sql, did);
        if (list.size() == 0) {
            return null;
        }
        Map<String, Object> one = list.get(0);
        return ormDpt(one);
    }

    //通过id进行记录修改，并返回执行结果（修改记录）
    public int updateById(Department department) {
        String sql = "update department set dname=?,info=? where did=?";
        return jt.update(sql, department.getDname(), department.getInfo(),
                department.getDid());
    }

    //DepartmentDAO中新加部门删除方法，传入部门id，返回操作结果
    public int deleteById(int did) {
        String sql = "delete from department where did=?";
        return jt.delete(sql, did);
    }


}
