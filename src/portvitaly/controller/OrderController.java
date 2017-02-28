package portvitaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import portvitaly.dao.OrderDao;
import portvitaly.dao.OrderDaoImpl;
import portvitaly.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @RequestMapping(path = "/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Order> orders = orderDao.allOrders();
            modelAndView.addObject("orders", orders);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }





}
