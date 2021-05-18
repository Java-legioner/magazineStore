package ua.ivashchuk.dao.impl;

import org.apache.log4j.Logger;
import ua.ivashchuk.dao.BucketDao;
import ua.ivashchuk.domain.Bucket;
import ua.ivashchuk.utils.ConnectionUtils;


import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class BucketDaoImpl implements BucketDao {

    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values(?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id=?";
    private static String DELETE_BY_ID = "delete from bucket where id=?";

    private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);


    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketDaoImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConnection();
    }


    @Override
    public List<Bucket> readAll() {
        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer bucketId = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                Integer product_id = rs.getInt("product_id");
                Date purchaseDate = rs.getDate("purchase_date");

                bucketRecords.add(new Bucket(bucketId, userId, product_id, purchaseDate));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucketRecords;
    }

    @Override
    public Bucket create(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            bucket.setId(rs.getInt(1));
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            Integer buckedId = rs.getInt("id");
            Integer userId = rs.getInt("user_id");
            Integer productId = rs.getInt("product_id");
            Date purchaseDate = rs.getDate("purchase_date");

            bucket = new Bucket(buckedId, userId, productId, purchaseDate);
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket bucket) {

        throw new IllegalStateException("There is no update for bucked");
    }

    @Override
    public void delete(Integer id)  {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
}
