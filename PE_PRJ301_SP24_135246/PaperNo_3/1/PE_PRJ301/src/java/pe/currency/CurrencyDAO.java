/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.currency;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author LAPTOP
 */
public class CurrencyDAO {
    public List<CurrencyDTO> searchCurrencies(String code, String name) throws Exception {
        List<CurrencyDTO> currencyList = new ArrayList<>();
        String sql = "SELECT code, name, description, rate FROM tblCurrency WHERE code LIKE ? OR name LIKE ?";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + code + "%");
            ps.setString(2, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String currencyCode = rs.getString("code");
                String currencyName = rs.getString("name");
                String description = rs.getString("description");
                double rate = rs.getDouble("rate");

                currencyList.add(new CurrencyDTO(currencyCode, currencyName, description, rate));
            }
        }
        return currencyList;
    }
}
