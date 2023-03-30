package com.dingli.dao;

import com.dingli.entity.Department;
import com.dingli.entity.Equipment;
import com.dingli.util.JdbcTools;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EquipmentDAO {

    ////注入JdbcTools全局变量
    private static JdbcTools jt = new JdbcTools();

    /**
     * Map转 Equipment 的orm映射方法
     *
     * @param map 传入的map
     * @return Equipment对象
     */
    public Equipment ormEquipment(Map<String, Object> map) {

        Equipment equipment = new Equipment();

        if (map.get("eid") != null) {
            equipment.setEid((int) map.get("eid"));
        }
        if (map.get("ename") != null) {
            equipment.setEname((String) map.get("ename"));
        }
        if (map.get("edescribe") != null) {
            equipment.setEdescribe((String) map.get("edescribe"));
        }
        if(map.get("edname") != null){
            equipment.setEdname((String) map.get("edname"));
        }
        return equipment;


    }

    //设备相关操作，将方法写入 EquipmentDAO 中，该方法查询 “设备表” 所有信息，返回List结果集
    public List<Equipment> selectAll(){
        String sql = "select * from equipment";
        List<Map<String,Object>> list = jt.select(sql);
        if (list.size() == 0){
            return null;
        }
        List<Equipment> result = new LinkedList<>();
        list.forEach(one ->{
            ormEquipment(one);
            result.add(ormEquipment(one));
        });
        return result;
    }

    //返回JDBC操作后的结果值（插入记录）
    public  int insert(Equipment ept){
        String sql = "insert into equipment(eid,ename,edescribe,edname) value(?,?,?,?)";
        return jt.insert(sql, ept.getEid(),ept.getEname(), ept.getEdescribe(),ept.getEdname());
    }

    //通过id进行记录修改，并返回执行结果（更新）
    public static int updateById(Equipment equipment) {
        String sql = "update department set dname=?,info=? where did=?";
        return jt.update(sql, equipment.getEname(), equipment.getEdescribe(),
                equipment.getEid());
    }



}
