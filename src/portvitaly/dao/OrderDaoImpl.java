package portvitaly.dao;

import org.springframework.stereotype.Component;
import portvitaly.entity.Order;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDaoImpl extends Dao implements OrderDao{
    private final String ALL_ORDERS = "SELECT `id_order`, `article`, `cost`, `width`, `height`, `length` FROM orders";
    private final String ADD_ORDER = "INSERT INTO orders (id_order, article, cost, width, height, length) VALUES (NULL, ?, ?, ?, ?, ?)";
    private final String UPDATE_ORDER = "UPDATE orders SET `article`=?, `cost`=?, `width`=?, `height`=?, `length`=? WHERE `id_order` = ?";
    private final String DELETE_ORDER = "DELETE FROM orders WHERE `id_order` = ?";
    private final String SELECT_ORDER = "SELECT `id_order`, `article`, `cost`, `width`, `height`, `length` FROM orders WHERE `id_order` = ?";


    public OrderDaoImpl(){
        super();
    }

    @Override
    public List<Order> allOrders() throws SQLException, NamingException {
        openConnection();

        List<Order> orders = new ArrayList<>();
        try(PreparedStatement prepStatement = connection.prepareStatement(ALL_ORDERS)){
            ResultSet resultOrders = prepStatement.executeQuery();
            while(resultOrders.next()){
                Order order = new Order(
                        resultOrders.getInt("id_order"),
                        resultOrders.getString("article"),
                        resultOrders.getInt("cost"),
                        resultOrders.getInt("width"),
                        resultOrders.getInt("height"),
                        resultOrders.getInt("length")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return orders;
    }

    @Override
    public Order addOrder(Order order) throws SQLException, NamingException {
        openConnection();
//        Order newOrder = new Order();
        try(PreparedStatement prepStatement = connection.prepareStatement(ADD_ORDER)){
            prepStatement.setString(1,order.getArticle());
            prepStatement.setInt(2,order.getCost());
            prepStatement.setInt(3,order.getWidth());
            prepStatement.setInt(4,order.getHeight());
            prepStatement.setInt(5,order.getLength());

            int resultOperation = prepStatement.executeUpdate();
            if(resultOperation == 1)
                System.out.println("Добавление прошло успешно");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return order;
    }

    @Override
    public void deleteOrder(int idOrder) throws SQLException, NamingException {
        openConnection();
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_ORDER)){
            prepStatement.setInt(1,idOrder);

            int resultOperation = prepStatement.executeUpdate();
            if(resultOperation == 1)
                System.out.println("Удаление прошло успешно");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }

    @Override
    public Order updateOrder(Order order) throws SQLException, NamingException {
        openConnection();
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_ORDER)){
            prepStatement.setString(1,order.getArticle());
            prepStatement.setInt(2,order.getCost());
            prepStatement.setInt(3,order.getWidth());
            prepStatement.setInt(4,order.getHeight());
            prepStatement.setInt(5,order.getLength());
            prepStatement.setInt(6,order.getId());

            int resultOperation = prepStatement.executeUpdate();
            if(resultOperation == 1)
                System.out.println("Изменение прошло успешно");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return order;
    }

    @Override
    public Order getOrderById(int idOrder) throws SQLException, NamingException, NullPointerException {
        openConnection();
        Order order = null;
        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ORDER)){
            prepStatement.setInt(1,idOrder);

            ResultSet resultOrders = prepStatement.executeQuery();
            while(resultOrders.next()) {
                order = new Order(
                        resultOrders.getInt("id_order"),
                        resultOrders.getString("article"),
                        resultOrders.getInt("cost"),
                        resultOrders.getInt("width"),
                        resultOrders.getInt("height"),
                        resultOrders.getInt("length")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return order;
    }
}
