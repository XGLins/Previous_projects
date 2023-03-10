package com.dingli.dao;

import com.dingli.entity.Card;
import com.dingli.util.JdbcTools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CardDAO {
    //将JdbcTools以全局变量的形式注入到DAO中
    private JdbcTools jt = new JdbcTools();

    // Card类orm方法映射
    public Card ormCard(Map<String, Object> map) {
        Card card = new Card();
        if (map.get("cid") != null) {
            card.setCid((int) map.get("cid"));
        }
        if (map.get("type") != null) {
            card.setType((String) map.get("type"));
        }
        if (map.get("account") != null) {
            card.setAccount((Double) map.get("account"));
        }
        if (map.get("create_time") != null) {
            card.setCreateTime((Date) map.get("create_time"));
        }
        if (map.get("uid") != null) {
            card.setUid((int) map.get("uid"));
        }
        return card;
    }

    /**
     * 方法区域
     * */
    public List<Card> list() {
        String sql = "select * from card";
        List<Map<String, Object>> list = jt.select(sql);
        List<Card> result = new ArrayList<>();
        list.forEach(one -> result.add(ormCard(one)));
        return result;
    }

    //添加插入记录方法，传入Card对象，返回操作结果。
    public int insert(Card card) {
        String sql = "insert into card(type,account,create_time,uid) value(?,?,?,?)";
        return jt.insert(sql, card.getType(), card.getAccount(),
                card.getCreateTime(), card.getUid());
    }

    //添加银行卡信息删除方法，传入卡号，返回操
    public int deleteById(int cid) {
        String sql = "delete from card where cid=?";
        return jt.delete(sql, cid);
    }

    //菜单三:根据卡号查询卡信息方法
    public Card selectById(int cid) {
        String sql = "select * from card where cid=?";
        List<Map<String, Object>> list = jt.select(sql, cid);
        if (list.size() == 0) {
            return null;
        }
        return ormCard(list.get(0));
    }

    //添加存款方法，传入存款卡号及金额，返回操作
    public int saveMoney(int cid, double money) {
        //查询原余额
        Card card = selectById(cid);
        //设置新余额
        card.setAccount(card.getAccount() + money);
        //更新余额
        String sql = "update card set account=? where cid=?";
        return jt.update(sql, card.getAccount(), cid);
    }

    //添加取款方法，传入取款卡号及金额，返回操作
    public int getMoney(int cid, double money) {
        //查询原余额
        Card card = selectById(cid);
        //设置新余额
        card.setAccount(card.getAccount() - money);
        //更新余额
        String sql = "update card set account=? where cid=?";
        return jt.update(sql, card.getAccount(), cid);
    }




}
