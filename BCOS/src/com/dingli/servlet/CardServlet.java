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
import java.util.Date;
import java.util.List;

/**
 * 银行卡管理
 * */
@WebServlet("/CardServlet.do")
public class CardServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();
    private CardDAO cardDAO = new CardDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equals("show")) {
            //列表展示
            List<Card> cardList = cardDAO.list();
            for (Card card : cardList) {
                User user = userDAO.selectById(card.getUid());
                card.setUser(user);
            }
            request.setAttribute("cardList", cardList);
            request.getRequestDispatcher("./jsp/showCard.jsp").forward(request,
                    response);
        }else if (action.equals("goAdd")) {
            request.getRequestDispatcher("./jsp/addCard.jsp").forward(request,
                    response);
        }else if (action.equals("getOpener")) {
            String uid = request.getParameter("uid");
            User user = userDAO.selectById(Integer.parseInt(uid));
            response.getWriter().println(user == null ? "" : user.getUname());
        }else if (action.equals("add")) {
            //新增银行卡信息
            String type = request.getParameter("type");
            String account = request.getParameter("account");
            String uid = request.getParameter("uid");
            Card card = new Card(0, type, Double.parseDouble(account), new Date(),
                    Integer.parseInt(uid));

            User user = userDAO.selectById(Integer.parseInt(uid));
            if (user == null) {
                request.setAttribute("message", "账号有误，开卡操作失败！");
                request.getRequestDispatcher("CardServlet.do?action=show").forward(request,
                        response);
                return;
            }

            int count = cardDAO.insert(card);
            if (count > 0) {
                request.setAttribute("message", "开卡成功！");
            } else {
                request.setAttribute("message", "开卡失败！");
            }
            request.getRequestDispatcher("./CardServlet.do?action=show").forward(request,
                    response);
        }else if (action.equals("delete")) {
            String cid = request.getParameter("cid");
            int count = cardDAO.deleteById(Integer.parseInt(cid));
            if (count > 0) {
                request.setAttribute("message", "销卡成功！");
            } else {
                request.setAttribute("message", "销卡失败！");
            }
            request.getRequestDispatcher("./CardServlet.do?action=show").forward(request,
                    response);
        }


    }
}
