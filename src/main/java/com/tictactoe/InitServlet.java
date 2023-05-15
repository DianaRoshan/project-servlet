package com.tictactoe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        Field field=new Field();

        List<Sign> data=field.getFieldData();

        // Добавление в сессию параметров поля (нужно будет для хранения состояния между запросами)
        httpSession.setAttribute("field", field);
        // и значений поля, отсортированных по индексу (нужно для отрисовки крестиков и ноликов)
        httpSession.setAttribute("data", data);

        // Перенаправление запроса на страницу index.jsp через сервер
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
