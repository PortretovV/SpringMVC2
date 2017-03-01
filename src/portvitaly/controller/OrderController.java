package portvitaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import portvitaly.dao.OrderDao;
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
        ModelAndView modelAndView = indexOrderList();
        return modelAndView;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView add(
            @RequestParam("article") String article,
            @RequestParam("cost") int cost,
            @RequestParam("lenght") int lenght,
            @RequestParam("width") int width,
            @RequestParam("height") int height
    ){
        Order order = new Order(article,cost,width,height,lenght);
        try {
            order = orderDao.addOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = indexOrderList();
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("id") int id){
        try {
            orderDao.deleteOrder(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = indexOrderList();
        return modelAndView;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail( @RequestParam("id") int id
    ){
        ModelAndView modelAndView = new ModelAndView();
        try {
            Order order = orderDao.getOrderById(id);
            modelAndView.addObject("order",order);
            modelAndView.setViewName("detail");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        try {
            Order order = orderDao.getOrderById(id);
            modelAndView.addObject("order", order);
            modelAndView.setViewName("update");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ModelAndView update(
            @RequestParam("id") int id,
            @RequestParam("article") String article,
            @RequestParam("cost") int cost,
            @RequestParam("lenght") int lenght,
            @RequestParam("width") int width,
            @RequestParam("height") int height
    ){
        Order order = new Order(id,article,cost,width,height,lenght);
        try {
            order = orderDao.updateOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = indexOrderList();
        return modelAndView;
    }

    private ModelAndView indexOrderList(){
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
