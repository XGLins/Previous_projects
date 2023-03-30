package com.dingli.servlet;

import com.dingli.dao.EquipmentDAO;
import com.dingli.entity.Department;
import com.dingli.entity.Equipment;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 设备管理
 * */
@WebServlet("/EquipmentServlet.do")
public class EquipmentServlet extends HttpServlet {

    //创建EquipmentDAO对象
    private EquipmentDAO eptDAO = new EquipmentDAO();

    //Servlet初始化
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
                           response) throws ServletException, IOException {

        //解决文字乱码问题
        request.setCharacterEncoding("utf-8");//如果缺少 暂时了解到 不影响输出
        response.setCharacterEncoding("utf-8");//如果缺少 输出：Servlet????
        response.setContentType("text/html");//如果缺少 输出：Servlet璁块棶鎴愬姛

        //在空白页面上打印以下文字
        response.getWriter().println("<h1>Servlet访问成功</h1>");


        String action = request.getParameter("action");
        if (action.equals("show")){
            //显示设备管理列表
            List<Equipment> equipmentList = eptDAO.selectAll();
            request.setAttribute("equipmentList",equipmentList);
            request.getRequestDispatcher("./jsp/showEquipment.jsp").forward(request,
                    response);
        }else if (action.equals("goAdd")) {
            // 去往添加设备信息界面
            request.getRequestDispatcher("./jsp/addEpt.jsp").forward(request,
                    response);
        }else if (action.equals("add")){
            //设备新增
//            String eid = request.getParameter("eid");
            String ename = request.getParameter("ename");
            String edescribe = request.getParameter("edescribe");
            String edname = request.getParameter("edname");
            Equipment ept = new Equipment(0,ename,edescribe,edname);
            int count = eptDAO.insert(ept);
            if (count > 0){
                request.setAttribute("message","新增设备成功！");
            }else{
                request.setAttribute("message","新增设备失败！");
            }
            request.getRequestDispatcher("./EquipmentServlet.do?action=show").forward(request,response);
        } else if (action.equals("update")){
            //部门修改
            String ename = request.getParameter("ename");
            String edescribe = request.getParameter("edescribe");
            String edname = request.getParameter("edname");
            Equipment ept = new Equipment(0,ename, edescribe, edname);

            //数据层调用
            int count = EquipmentDAO.updateById(ept);
            if (count > 0) {
                request.setAttribute("message", "修改部门成功！");
            } else {
                request.setAttribute("message", "修改部门失败！");
            }
            request.getRequestDispatcher("./EquipmentServlet.do?action=show").forward(request, response);

        }



    }



}
