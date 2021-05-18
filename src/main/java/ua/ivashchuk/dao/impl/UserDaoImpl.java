package ua.ivashchuk.dao.impl;

import org.apache.log4j.Logger;
import ua.ivashchuk.dao.UserDao;
import ua.ivashchuk.domain.User;
import ua.ivashchuk.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static String READ_ALL = "select * from user";
    private static String CREATE = "insert into user(`first_name`, `last_name`,`email`, `password`, `role`) values(?,?,?,?,?)";
    private static String READ_BY_ID = "select * from user where id=?";
    private static String READ_BY_EMAIL = "select * from user where email=?";
    private static String UPDATE_BY_ID = "update user set  first_name=?, last_name=?, email=?, password=?, role=? where id=?";
    private static String DELETE_BY_ID = "delete from user where id=?";

    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConnection();
    }


    @Override
    public List<User> readAll()  {
        List<User> userRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer userId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                userRecords.add(new User(userId, firstName, lastName, email, password, role));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return userRecords;
    }

    @Override
    public User create(User user)  {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            Integer userId = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String role = rs.getString("role");

            user = new User(userId, firstName, lastName, email, password, role);
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return user;
    }

    @Override
    public User update(User user)  {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setInt(6,user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return user;
    }

    @Override
    public void delete(Integer id)  {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }

    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            Integer userId = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String password = rs.getString("password");
            String role = rs.getString("role");

            user = new User(userId, firstName, lastName, email, password, role);
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return user;
    }
}
