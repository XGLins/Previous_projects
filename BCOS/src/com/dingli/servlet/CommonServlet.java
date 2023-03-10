package com.dingli.servlet;

import com.dingli.dao.CardDAO;
import com.dingli.dao.UserDAO;
import com.dingli.entity.Card;
import com.dingli.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 常规业务处
 * */
@WebServlet("/CommonServlet.do")
public class CommonServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();
    private CardDAO cardDAO = new CardDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        //获取操作指令
        String action = request.getParameter("action");
        if (action.equals("index")) {
            request.getRequestDispatcher("./jsp/common.jsp").forward(request,
                    response);
        }else if (action.equals("goQuery")) {
            request.getRequestDispatcher("./jsp/query.jsp").forward(request,
                    response);
        }else if (action.equals("query")) {
            String cid = request.getParameter("cid");
            Card card = cardDAO.selectById(Integer.parseInt(cid));
            if (card == null) {
                response.getWriter().println("卡号有误，无查询结果！");
            } else {
                response.getWriter().println("当前余额：" + card.getAccount());
            }
        }else if (action.equals("goSave")) {
            request.getRequestDispatcher("./jsp/save.jsp").forward(request,
                    response);
        }else if (action.equals("save")) {
            //存款操作
            String cid = request.getParameter("cid");
            String money = request.getParameter("money");
            Card card = cardDAO.selectById(Integer.parseInt(cid));
            if (card == null) {
                request.setAttribute("message", "卡号有误，存款失败！");
                request.getRequestDispatcher("CommonServlet.do?action=goSave").forward(request,
                        response);
                return;
            }

            int count = cardDAO.saveMoney(Integer.parseInt(cid),
                    Double.parseDouble(money));
            if (count > 0) {
                request.setAttribute("message", "存款成功！");
            } else {
                request.setAttribute("message", "存款失败！");
            }
            request.getRequestDispatcher("CommonServlet.do?action=goSave").forward(request, response);
        }else if (action.equals("goGet")) {
            request.getRequestDispatcher("./jsp/getMoney.jsp").forward(request,
                    response);
        }else if (action.equals("get")) {
            //取款操作
            String cid = request.getParameter("cid");
            String money = request.getParameter("money");
            Card card = cardDAO.selectById(Integer.parseInt(cid));
            if (card == null) {
                request.setAttribute("message", "卡号有误，取款失败！");
                request.getRequestDispatcher("CommonServlet.do?action=goGet").forward(request,
                        response);
                return;
            }

            if (card.getAccount() < Double.parseDouble(money)) {
                request.setAttribute("message", "余额不足，取款失败！");
                request.getRequestDispatcher("CommonServlet.do?action=goGet").forward(request,
                        response);
                return;
            }

            int count = cardDAO.getMoney(Integer.parseInt(cid),
                    Double.parseDouble(money));
            if (count > 0) {
                request.setAttribute("message", "取款成功！");
            } else {
                request.setAttribute("message", "取款失败！");
            }
            request.getRequestDispatcher("CommonServlet.do?action=goGet").forward(request,
                    response);
        }else if (action.equals("goTransfer")) {
            //跳转转账界面
            request.getRequestDispatcher("./jsp/transfer.jsp").forward(request,
                    response);
        }else if (action.equals("getUnameByCid")) {
            String cid = request.getParameter("cid");
            //cid为空，返回"未知"
            if (cid == null || cid.trim().equals("")) {
                response.getWriter().println("未知");
                return;
            }
            Card card = cardDAO.selectById(Integer.parseInt(cid));
            //卡号不存在，返回"未知"
            if (card == null) {
                response.getWriter().println("未知");
                return;
            }
            //卡号存在，查询用户并响应用户名称
            User user = userDAO.selectById(card.getUid());
            response.getWriter().println(user.getUname());
        }else if (action.equals("transfer")) {
            //接受前端参数
            String cid1 = request.getParameter("cid1");
            String cid2 = request.getParameter("cid2");
            String money = request.getParameter("money");
            //判断参数是否有误
            if (cid1 == null || cid1.trim().equals("") ||
                    cid2 == null || cid2.trim().equals("") ||
                    money == null || money.trim().equals("")) {
                request.setAttribute("message", "参数有误，请检查参数后操作！");
                request.getRequestDispatcher("./CommonServlet.do?action=goTransfer").forward(request, response);
                return;
            }

            //判断卡号是否都存在
            Card card1 = cardDAO.selectById(Integer.parseInt(cid1));
            Card card2 = cardDAO.selectById(Integer.parseInt(cid2));
            if (card1 == null || card2 == null) {
                request.setAttribute("message", "存在未知卡号，请检查参数后操作！");
                request.getRequestDispatcher("./CommonServlet.do?action=goTransfer").forward(request, response);
                return;
            }

            //余额不足，返回界面，提示信息
            if (card1.getAccount() < Double.parseDouble(money)) {
                request.setAttribute("message", "转账卡余额不足！");
                request.getRequestDispatcher("./CommonServlet.do?action=goTransfer").forward(request, response);
                return;
            }

            //转账卡减钱，接收卡加钱
            int count1 = cardDAO.getMoney(Integer.parseInt(cid1),
                    Double.parseDouble(money));
            int count2 = cardDAO.saveMoney(Integer.parseInt(cid2),
                    Double.parseDouble(money));
            if (count1 > 0 && count2 > 0) {
                request.setAttribute("message", "转账成功！");
            } else {
                request.setAttribute("message", "转账失败！");
            }
            request.getRequestDispatcher("./CommonServlet.do?action=goTransfer").forward(request, response);


        }




    }
}
