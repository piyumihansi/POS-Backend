package lk.ijse.posbackend.dao.impl;

import lk.ijse.posbackend.dao.OrderDetailDAO;
import lk.ijse.posbackend.dto.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDetailDAOIMPL implements OrderDetailDAO {
    public static String SAVE_ORDER_ITEM_DETAIL = "INSERT INTO order_detail (order_id, item_id, qty) VALUES(?,?,?)";

    @Override
    public boolean saveOrderDetail(OrderDetailDTO orderDetailDTO, Connection connection) throws Exception {
        // System.out.println("customer Dao  "+customer.getCustAddress());
        try {
            var ps = connection.prepareStatement(SAVE_ORDER_ITEM_DETAIL);
            ps.setString(1, orderDetailDTO.getOrder_id());
            ps.setString(2, orderDetailDTO.getItem_code());
            ps.setInt(3, orderDetailDTO.getQty());

            if (ps.executeUpdate() !=0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
